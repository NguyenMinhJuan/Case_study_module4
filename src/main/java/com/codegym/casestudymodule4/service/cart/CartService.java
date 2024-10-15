package com.codegym.casestudymodule4.service.cart;

import com.codegym.casestudymodule4.model.Cart;
import com.codegym.casestudymodule4.model.CartItem;
import com.codegym.casestudymodule4.repository.CartItemRepo;
import com.codegym.casestudymodule4.repository.ICartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private ICartRepo cartRepo;
    @Autowired
    private CartItemRepo cartItemRepo;

    public Cart getCartById(Long id) {
        return cartRepo.findById(id).orElse(new Cart());
    }

    public void addItemToCart(Long cartId, CartItem item) {
        Cart cart = getCartById(cartId);
        item.setCart(cart);
        cart.getItems().add(item);
        cartItemRepo.save(item);
        cartRepo.save(cart);
    }

    public void removeItemFromCart(Long cartId, Long itemId) {
        Cart cart = getCartById(cartId);
        cart.getItems().removeIf(item -> item.getCartItemId().equals(itemId));
        cartItemRepo.deleteById(itemId);
        cartRepo.save(cart);
    }

    public double calculateTotalPrice(Cart cart) {
        return cart.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

}
