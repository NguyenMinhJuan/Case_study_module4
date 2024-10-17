package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserUserId(Long userId);
}
