package com.codegym.casestudymodule4.service.order;

import com.codegym.casestudymodule4.model.DTO.OrderDTO;
import com.codegym.casestudymodule4.model.Order;
import com.codegym.casestudymodule4.model.OrderItem;
import com.codegym.casestudymodule4.service.IGenerateService;

import java.util.List;

public interface IOrderService extends IGenerateService<Order> {
    Order createOrder(OrderDTO orderDTO);
    public List<OrderItem> getOrderItemsByUserId(Long userId);
}
