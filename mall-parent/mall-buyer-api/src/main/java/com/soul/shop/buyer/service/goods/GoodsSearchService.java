package com.soul.shop.buyer.service.goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

@Service
public class GoodsSearchService {

  private static final String HOT_WORDS_REDIS_KEY = "goods_hot_words";

  @Autowired
  private StringRedisTemplate redisTemplate;

  /**
   * 1. redis的zset 数据结构
   * 2. 要按照score 从大到小牌
   * 3. redis数据来运，先用测试数据，后期做搜索的时候，redis数据 通过搜索接口放入
   *
   * @param start
   * @param end
   * @return
   */
  public List<String> getHotWords(Integer start, Integer end) {
    // 前端来的start 是从1开始的，所以先-1.
    start = (start - 1) * end;
    end = start + end;
    Set<TypedTuple<String>> typedTuples = redisTemplate.opsForZSet()
        .reverseRangeWithScores(HOT_WORDS_REDIS_KEY, start, end);

    List<String> hotWords = new ArrayList<>();
    if (typedTuples == null) {
      return hotWords;
    }
    typedTuples.forEach(
        typedTuple -> hotWords.add(typedTuple.getValue())
    );
    return hotWords;
  }
}
