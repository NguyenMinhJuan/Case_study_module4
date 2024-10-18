package com.codegym.casestudymodule4.service.coupon;

import com.codegym.casestudymodule4.model.Coupon;
import com.codegym.casestudymodule4.repository.ICouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    @Autowired
    private ICouponRepository ICouponRepository;

    public List<Coupon> findAll() {
        return ICouponRepository.findAll();
    }

    public Coupon findById(Long id) {
        return ICouponRepository.findById(id).orElse(null);
    }

    public Coupon save(Coupon coupon) {
        return ICouponRepository.save(coupon);
    }

    public void delete(Long id) {
        ICouponRepository.deleteById(id);
    }
}

