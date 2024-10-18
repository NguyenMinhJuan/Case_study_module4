package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends JpaRepository<Cart,Long> {
    @Query(value = "select cart_id from carts where user_id = :userId", nativeQuery = true)
    Long getCartId(@Param("userId") Long userId);
}
