package com.soul.shop.buyer.service.impl.goods;

import com.soul.shop.buyer.service.GoodsService;
import com.soul.shop.model.buyer.params.EsGoodsSearchParam;
import com.soul.shop.model.buyer.params.PageParams;
import com.soul.shop.model.buyer.pojo.es.EsGoodsIndex;
import com.soul.shop.model.buyer.vo.goods.GoodsPageVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.*;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@DubboService(version = "1.0.0", interfaceClass = GoodsService.class)
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    /**
     * 1. 拿到搜索 本质上很多，目前只做首页的搜索，所以暂时嘉定条件只有一个keyword
     * 2. es中查询商品名称是否匹配（一定匹配）
     * 3. 卖点也需要进行匹配（不一定要匹配）
     * @param goodsSearchParams
     * @param pageParams
     * @return
     */
    @Override
    public GoodsPageVO searchGoods(EsGoodsSearchParam goodsSearchParams, PageParams pageParams) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        String keyword = goodsSearchParams.getKeyword();
        if (StringUtils.isNotBlank(keyword)) {
            MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("goodsName", keyword);
            MatchQueryBuilder matchQueryBuilder1 = QueryBuilders.matchQuery("sellingPoint", keyword);
            boolQueryBuilder.must(matchQueryBuilder);
            boolQueryBuilder.should(matchQueryBuilder1);
        }

        log.info("pageParams.getPageNumber() is: " + pageParams.getPageNumber());
        PageRequest pageRequest = PageRequest.of(pageParams.getPageNumber(), pageParams.getPageSize());
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withPageable(pageRequest)
                .build();
        SearchHits<EsGoodsIndex> search = elasticsearchTemplate.search(query, EsGoodsIndex.class);
        SearchPage<EsGoodsIndex> searchHits = SearchHitSupport.searchPageFor(search, pageRequest);

        GoodsPageVO goodsPageVO = new GoodsPageVO();
        goodsPageVO.setTotalElements(searchHits.getTotalElements());
        List<EsGoodsIndex> collect = searchHits.getContent().stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
        goodsPageVO.setContent(collect);
        return goodsPageVO;
    }
}
