package com.codegym.casestudymodule4.service.cartItems;

import com.codegym.casestudymodule4.model.CartItem;
import com.codegym.casestudymodule4.repository.ICartItemRepository;
import com.codegym.casestudymodule4.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemsService implements ICartItemsService {
    @Autowired
    ICartItemRepository icartItemRepository;

    @Override
    public Iterable<CartItem> getCartItems(Long cartId) {
        return icartItemRepository.listItemsByCartId(cartId);
    }
}
