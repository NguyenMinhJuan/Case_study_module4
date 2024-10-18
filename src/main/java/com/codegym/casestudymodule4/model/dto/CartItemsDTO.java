package com.codegym.casestudymodule4.model.dto;

import com.codegym.casestudymodule4.model.CartItem;

public interface CartItemsDTO {
    Iterable<CartItem> items();
}
