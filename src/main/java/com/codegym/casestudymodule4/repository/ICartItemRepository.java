package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartItemRepository extends JpaRepository<CartItem,Long> {
    @Query(value = "select * from cart_items where cart_id= :cartId;", nativeQuery = true)
    Iterable<CartItem> listItemsByCartId(@Param("cartId") Long cartId);

}
