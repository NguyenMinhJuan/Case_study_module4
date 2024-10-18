package com.codegym.casestudymodule4.service.cart;

import com.codegym.casestudymodule4.model.Cart;
import com.codegym.casestudymodule4.model.CartItem;
import com.codegym.casestudymodule4.service.IGenerateService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICartService extends IGenerateService<Cart> {
    Long getCartIdByUserId(Long userId);
}
