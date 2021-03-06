package com.soul.shop.buyer.service.impl.goods;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.soul.shop.buyer.mapper.GoodsSkuMapper;
import com.soul.shop.buyer.service.CategoryService;
import com.soul.shop.buyer.service.GoodsSkuService;
import com.soul.shop.common.vo.Result;
import com.soul.shop.model.buyer.pojo.es.EsGoodsIndex;
import com.soul.shop.model.buyer.pojo.goods.GoodsSku;
import com.soul.shop.model.buyer.vo.goods.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@DubboService(version = "1.0.0")
public class GoodsSkuServiceImpl implements GoodsSkuService {

    @Resource
    private GoodsSkuMapper goodsSkuMapper;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void importES() {
        LambdaQueryWrapper<GoodsSku> queryWrapper = new LambdaQueryWrapper<>();
        List<GoodsSku> goodsSkus = goodsSkuMapper.selectList(queryWrapper);
        for (GoodsSku goodsSku : goodsSkus) {
            EsGoodsIndex esGoodsIndex = new EsGoodsIndex();
            BeanUtils.copyProperties(goodsSku,esGoodsIndex);

            esGoodsIndex.setId(goodsSku.getId().toString());
            esGoodsIndex.setGoodsId(goodsSku.getGoodsId().toString());
            esGoodsIndex.setPrice(goodsSku.getPrice().doubleValue());
            BigDecimal promotionPrice = goodsSku.getPromotionPrice();
            if (promotionPrice != null) {
                esGoodsIndex.setPromotionPrice(promotionPrice.doubleValue());
            }
            elasticsearchRestTemplate.save(esGoodsIndex);
        }
    }

    /**
     * ?????????GoodsDetailVo
     * 1. ??????skuid ?????? goodsSku??? ????????????GoodsSkuVO??????
     * 2. categoryName ????????? ????????????id????????????????????????id?????? ?????????????????????
     * 3. specs sku????????? json???spec??????????????????????????????????????????
     * 4. ???????????? ???????????????
     *
     * @param goodsId
     * @param skuId
     * @return
     */
    @Override
    public Result<GoodsDetailVO> getGoodsSkuDetail(String goodsId, String skuId) {
        //??????skuid ???null ?????? ????????????????????????????????????
        //????????????id?????????????????????id ??????sku??????
        if (goodsId == null) {
            return Result.fail(-999, "????????????");
        }
        GoodsDetailVO goodsDetailVO = new GoodsDetailVO();
        GoodsSku goodsSku;
        if (skuId == null) {
            // ????????????id??????
            LambdaQueryWrapper<GoodsSku> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(GoodsSku::getGoodsId, Long.parseLong(goodsId));
            List<GoodsSku> goodsSkus = goodsSkuMapper.selectList(queryWrapper);
            if (goodsSkus.size() <= 0) {
                return Result.fail(-999, "????????????");
            }
            goodsSku = goodsSkus.get(0);
        } else {
            log.info("skuId is: {}", skuId);
            long id = Long.parseLong(skuId);
            goodsSku = goodsSkuMapper.selectById(id);
        }
        GoodsSkuVO goodsSkuVO = getGoodsSkuVO(goodsSku);
        goodsDetailVO.setData(goodsSkuVO);

        // ????????????
        String categoryPath = goodsSku.getCategoryPath();
        List<String> categoryNames = categoryService.getCategoryNameByIds(Arrays.asList(categoryPath.split(",")));
        goodsDetailVO.setCategoryName(categoryNames);

        // ????????????
        List<SpecValueVO> specList = goodsSkuVO.getSpecList();
        List<GoodsSkuSpecVO> goodsSkuSpecVOList = new ArrayList<>();
        GoodsSkuSpecVO goodsSkuSpecVO = new GoodsSkuSpecVO();
        goodsSkuSpecVO.setSkuId(goodsSku.getId().toString());
        goodsSkuSpecVO.setQuantity(goodsSku.getQuantity());
        goodsSkuSpecVO.setSpecValues(specList);
        goodsSkuSpecVOList.add(goodsSkuSpecVO);
        goodsDetailVO.setSpecs(goodsSkuSpecVOList);

        // ????????????
        goodsDetailVO.setPromotionMap(new HashMap<>());
        return Result.success(goodsDetailVO);
    }

    @Override
    public GoodsSku findGoodsSkuById(String skuId) {
        return goodsSkuMapper.selectById(skuId);
    }

    public GoodsSkuVO getGoodsSkuVO(GoodsSku goodsSku) {

        GoodsSkuVO goodsSkuVO = new GoodsSkuVO();
        BeanUtils.copyProperties(goodsSku, goodsSkuVO);
        //??????sku??????
        JSONObject jsonObject = JSON.parseObject(goodsSku.getSpecs());
        //????????????sku??????
        List<SpecValueVO> specValueVOS = new ArrayList<>();
        //????????????sku??????
        List<String> goodsGalleryList = new ArrayList<>();
        //???????????????sku??????
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            SpecValueVO specValueVO = new SpecValueVO();
            if (entry.getKey().equals("images")) {
                specValueVO.setSpecName(entry.getKey());
                if (entry.getValue().toString().contains("url")) {
                    List<SpecImages> specImages = JSON.parseArray(entry.getValue().toString(), SpecImages.class);
                    specValueVO.setSpecImage(specImages);
                    goodsGalleryList = specImages.stream().map(SpecImages::getUrl).collect(Collectors.toList());
                }
            } else {
                specValueVO.setSpecName(entry.getKey());
                specValueVO.setSpecValue(entry.getValue().toString());
            }
            specValueVOS.add(specValueVO);
        }
        goodsSkuVO.setGoodsGalleryList(goodsGalleryList);
        goodsSkuVO.setSpecList(specValueVOS);
        return goodsSkuVO;
    }

}
