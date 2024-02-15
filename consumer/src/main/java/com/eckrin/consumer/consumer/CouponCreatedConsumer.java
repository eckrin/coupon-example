package com.eckrin.consumer.consumer;

import com.eckrin.consumer.domain.Coupon;
import com.eckrin.consumer.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponCreatedConsumer {

    private final CouponRepository couponRepository;

    @KafkaListener(topics = "coupon_create", groupId = "group_1")
    public void listener(Long userId) {
        couponRepository.save(new Coupon(userId)); // rdb에 쿠폰 저장
    }
}
