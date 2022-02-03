package com.soul.shop.buyer.service.common;

import com.soul.shop.buyer.service.VerificationSourceService;
import com.soul.shop.common.enums.BusinessCodeEnum;
import com.soul.shop.common.utils.SerializableStream;
import com.soul.shop.common.utils.SliderImageCut;
import com.soul.shop.common.utils.SliderImageUtil;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.enums.VerificationEnums;
import com.soul.shop.model.buyer.vo.commons.VerificationVO;
import com.soul.shop.model.buyer.vo.commons.slider.VerificationSourceVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class VerificationService {

  @DubboReference(version = "1.0.0")
  private VerificationSourceService verificationSourceService;

  @Autowired
  private StringRedisTemplate redisTemplate;

  /**
   * 获取滑块验证的图片
   * 需要一个滑块，然后图片上扩出来一个和滑块一样的图片出来
   * 抠出来的这个图片，移动到对应的位置上之后，重新组合为一个完整的图片
   * 1. uuid 判断请求是否合法
   * 2. verificationCode 验证的类型 login(1), 首先判断参数合法
   * 3. 获取数据库verification_source表中的所有数据，分为两块，一个是资源数据，一个是滑块数据
   * 4. 从资源数据中，随机获取一个资源，随机获取一个滑块
   * 5. 从资源图片上抠一个和滑块一模一样的图片出来
   * 6. 记录相关的信息 x轴信息
   * 7. 相关的信息存入redis中，便于后续验证
   * @param verificationEnums
   * @param uuid
   * @return
   */
  public Result<SliderImageCut> createVerification(VerificationEnums verificationEnums, String uuid) {
    // step 1
    if (uuid == null) {
      return Result.fail(BusinessCodeEnum.ILLEGAL_REQUEST.getCode(), BusinessCodeEnum.ILLEGAL_REQUEST.getMsg());
    }
    // step 2
    if (verificationEnums == null) {
      return Result.fail(BusinessCodeEnum.ILLEGAL_REQUEST.getCode(), BusinessCodeEnum.DEFAULT_SYS_ERROR.getMsg());
    }
    // step 3
    VerificationVO verificationVO = verificationSourceService.findVerificationSource();
    List<VerificationSourceVO> verificationResources = verificationVO.getVerificationResources();
    List<VerificationSourceVO> verificationSliders = verificationVO.getVerificationSliders();
    // step 4
    Random random = new Random();
    //随机选择需要切的图下标和模板下标
    int resourceNum = random.nextInt(verificationResources.size());
    int sliderNum = random.nextInt(verificationSliders.size());
    VerificationSourceVO resource = verificationResources.get(resourceNum);
    VerificationSourceVO slider = verificationSliders.get(sliderNum);
    String resourceUrl = resource.getResource();
    String sliderUrl = slider.getResource();

    // step 5
    try {
      // 图片相应的处理操作
      SliderImageCut sliderImageCut = SliderImageUtil.pictureTemplatesCut(getInputStream(sliderUrl), getInputStream(resourceUrl));
      // 生成验证参数 120可以验证 无需手动清除，120秒有效时间自动清除
      redisTemplate.opsForValue().set(verificationRedisKey(uuid, verificationEnums), String.valueOf(sliderImageCut.getRandomX()), 120, TimeUnit.SECONDS);
      // 如果不设置为0, 滑块直接就匹配了
      sliderImageCut.setRandomX(0);
      return Result.success(sliderImageCut);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return Result.fail(-999, "创建校验错误");
  }

  private String verificationRedisKey(String uuid, VerificationEnums verificationEnums) {
    return "VERIFICATION_IMAGE_"+verificationEnums.name()+uuid;
  }

  /**
   * 根据网络地址，获取源文件
   * 这里简单说一下，这里是将不可序列化的inputstream序列化对象，存入redis缓存
   * @param originalResource
   * @return
   */
  private SerializableStream getInputStream(String originalResource) throws Exception {

    if (StringUtils.isNotEmpty(originalResource)) {
      URL url = new URL(originalResource);
      InputStream inputStream = url.openStream();
      SerializableStream serializableStream = new SerializableStream(inputStream);
      return serializableStream;
    }
    return null;
  }

  /**
   * 获取滑动验证的结果
   * 去redis验证xPos和redis存的是否一样
   * @param verificationEnums
   * @param uuid
   * @param xPos
   * @return
   */
  public Result preCheck(VerificationEnums verificationEnums, String uuid, Integer xPos) {
    log.info("successfully enterd method preCheck");
    String randomXStr = redisTemplate.opsForValue().get("VERIFICATION_IMAGE_" + verificationEnums.name() + uuid);
    if (randomXStr == null) {
      return Result.fail(-999, "验证码失效");
    }
    log.info("randomXStr: {}, xPos: {}", randomXStr, xPos);
    boolean result = Math.abs(Integer.parseInt(randomXStr) - xPos) < 8;
    log.info("result is " + result);
    if (result) {
      // 验证成功，记录验证结果，有效时间为120s
      redisTemplate.opsForValue().set("VERIFICATION_IMAGE_RESULT_" + verificationEnums.name() + uuid, "true", 120L);
      return Result.success(true);  // 前端接受到true时就会验证通过。
    }
    return Result.fail(-999, "验证失败");
  }
}
