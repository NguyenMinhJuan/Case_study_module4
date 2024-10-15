package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepo extends JpaRepository<Cart,Long> {
}
