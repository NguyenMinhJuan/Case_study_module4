package com.codegym.casestudymodule4.service.cartItems;

import com.codegym.casestudymodule4.model.CartItem;

public interface ICartItemsService {
    Iterable<CartItem> getCartItems(Long cartId);
}
