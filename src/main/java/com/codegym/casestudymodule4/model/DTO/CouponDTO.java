package com.codegym.casestudymodule4.model.DTO;

import java.time.LocalDate;

public interface CouponDTO {
    String getCode();
    Double getDiscountValue();
    LocalDate getExpiryDate();
}
