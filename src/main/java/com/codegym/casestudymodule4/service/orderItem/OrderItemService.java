package com.codegym.casestudymodule4.service.orderItem;

import com.codegym.casestudymodule4.model.OrderItem;
import com.codegym.casestudymodule4.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemService implements IOrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public Iterable<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public void remove(Long id) {
        orderItemRepository.deleteById(id);
    }
}
