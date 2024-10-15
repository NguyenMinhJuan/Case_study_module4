package com.codegym.casestudymodule4.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/cart")
public class CartController {
    @RequestMapping("/items")
    public String cartItems(Model model) {

        return "/merchant/products/list";
    }
}
