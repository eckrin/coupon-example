package com.eckrin.api.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponCreateProducer {

    private final KafkaTemplate<String, Long> kafkaTemplate;

    public void create(Long userId) {
        kafkaTemplate.send("coupon_create", userId);
    }
}
