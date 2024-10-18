package com.codegym.casestudymodule4.controller.user;

import com.codegym.casestudymodule4.model.CartItem;
import com.codegym.casestudymodule4.model.User;
import com.codegym.casestudymodule4.repository.ICartItemRepository;
import com.codegym.casestudymodule4.repository.ICartRepository;
import com.codegym.casestudymodule4.service.cart.CartService;
import com.codegym.casestudymodule4.service.cart.ICartService;
import com.codegym.casestudymodule4.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ICartItemRepository iCartItemRepository;

    @RequestMapping("/items")
    public String cartItems(Model model) {
        User currentUser = userService.getCurrentUser();
        Long cartId=cartService.getCartIdByUserId(currentUser.getUserId());
        model.addAttribute("cartItems",iCartItemRepository.listItemsByCartId(cartId));
        return "/user/cart-items";
    }
}
