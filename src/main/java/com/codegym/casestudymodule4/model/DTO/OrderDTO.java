package com.codegym.casestudymodule4.model.DTO;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDTO {
            private Long orderId;
            private Long ProductId;
            private Long userId; // ID của người dùng
            private Long merchantId; // ID của merchant
            private LocalDateTime orderDate;
            private List<OrderItemDTO> orderItems;
            private Integer quantity;// Danh sách các OrderItem

            // Getters and setters
        }

