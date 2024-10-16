package com.codegym.casestudymodule4.service.coupon;

import com.codegym.casestudymodule4.model.Coupon;
import com.codegym.casestudymodule4.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService implements ICouponService {
    @Autowired
    private CouponRepository couponRepository;


    @Override
    public Iterable<Coupon> findAll() {
        return couponRepository.findAll();
    }

    @Override
    public Optional<Coupon> findById(Long id) {
        return couponRepository.findById(id);
    }

    @Override
    public Coupon save(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public void remove(Long id) {
        couponRepository.deleteById(id);
    }


}

