package com.codegym.casestudymodule4.model.DTO;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long orderItemId;
    private Long productId; // ID của sản phẩm
    private Integer quantity; // Số lượng
    private Double price; // Giá sản phẩm
}
