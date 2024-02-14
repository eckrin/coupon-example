package com.eckrin.api.service;

import com.eckrin.api.domain.Coupon;
import com.eckrin.api.repository.CouponCountRepository;
import com.eckrin.api.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplyService {

    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;

    // redis의 incr 명령어 이용하여 key에 대한 value를 1씩 증가
    // redis incr 자체 성능이 좋고, redis가 싱글스레드에서 동작
    public void apply(Long userId) {
//        long count = couponRepository.count();
        long count = couponCountRepository.increment();

        if(count > 100) {
            return;
        }

        couponRepository.save(new Coupon(userId));
    }
}
