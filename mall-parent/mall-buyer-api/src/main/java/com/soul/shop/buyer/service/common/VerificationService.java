package com.soul.shop.buyer.service.common;

import com.soul.shop.common.vo.Result;
import org.springframework.stereotype.Service;

@Service
public class VerificationService {

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
   * @param verificationCode
   * @param uuid
   * @return
   */
  public Result createVerification(Integer verificationCode, String uuid) {
    return null;
  }

  /**
   * 获取滑动验证的结果
   * @param verificationCode
   * @param uuid
   * @param xPos
   * @return
   */
  public Result preCheck(Integer verificationCode, String uuid, Integer xPos) {
    return null;
  }
}
