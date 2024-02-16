package com.eckrin.consumer.consumer;

import com.eckrin.consumer.domain.Coupon;
import com.eckrin.consumer.domain.FailedEvent;
import com.eckrin.consumer.repository.CouponRepository;
import com.eckrin.consumer.repository.FailedEventRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponCreatedConsumer {

    private final CouponRepository couponRepository;
    private final FailedEventRepository failedEventRepository;
    private final Logger logger = LoggerFactory.getLogger(CouponCreatedConsumer.class);

    @KafkaListener(topics = "coupon_create", groupId = "group_1")
    public void listener(Long userId) {
        try {
            couponRepository.save(new Coupon(userId)); // rdb에 쿠폰 저장
        } catch (Exception e) { // 발급도중 실패시 FailedEvent 생성
            logger.error("failed to create coupon::" + userId);
            failedEventRepository.save(new FailedEvent(userId));
        }
    }
}
