package com.codegym.casestudymodule4.service.cart;

import com.codegym.casestudymodule4.model.Cart;
import com.codegym.casestudymodule4.model.CartItem;
import com.codegym.casestudymodule4.repository.ICartItemRepository;
import com.codegym.casestudymodule4.repository.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepo;
    @Autowired
    private ICartItemRepository ICartItemRepository;

    public Cart getCartById(Long id) {
        return cartRepo.findById(id).orElse(new Cart());
    }

    public void addItemToCart(Long cartId, CartItem item) {
        Cart cart = getCartById(cartId);
        item.setCart(cart);
        cart.getItems().add(item);
        ICartItemRepository.save(item);
        cartRepo.save(cart);
    }

    public void removeItemFromCart(Long cartId, Long itemId) {
        Cart cart = getCartById(cartId);
        cart.getItems().removeIf(item -> item.getCartItemId().equals(itemId));
        ICartItemRepository.deleteById(itemId);
        cartRepo.save(cart);
    }

    public double calculateTotalPrice(Cart cart) {
        return cart.getItems().stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    @Override
    public Iterable<Cart> findAll() {
        return null;
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Cart save(Cart cart) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Long getCartIdByUserId(Long userId) {
        return cartRepo.getCartId(userId);
    }


}
