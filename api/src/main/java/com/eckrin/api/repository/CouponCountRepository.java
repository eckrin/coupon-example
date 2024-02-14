package com.eckrin.api.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CouponCountRepository {

    private final RedisTemplate<String, String> redistemplate;

    public Long increment() {
        return redistemplate
                .opsForValue()
                .increment("coupon_count");
    }
}
