package com.eckrin.api.service;

import com.eckrin.api.repository.CouponRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplyServiceTest {

    @Autowired
    private ApplyService applyService;
    @Autowired
    private CouponRepository couponRepository;

    @Test
    @DisplayName("쿠폰 한개 발급")
    public void enterCoupon() {
        applyService.apply(1L);

        assertThat(couponRepository.count()).isEqualTo(1);
    }
}