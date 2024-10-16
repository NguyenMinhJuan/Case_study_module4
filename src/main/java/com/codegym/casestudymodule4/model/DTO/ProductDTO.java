package com.codegym.casestudymodule4.model.DTO;

import com.codegym.casestudymodule4.model.ENUM.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public interface ProductDTO {
    Long getProductId();
    String getName();
    String getDescription();
    Double getPrice();
    String getImageUrl();
    ProductStatus getStatus();
    boolean isPromoted();  // Phương thức getter cho trường boolean
}