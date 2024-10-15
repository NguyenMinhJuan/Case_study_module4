package com.codegym.casestudymodule4.controller.index;

import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private ProductService productService;


    @RequestMapping
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index/index";
    }

    @RequestMapping("/admin")
    public String admin(Model model){
        return "/admin/dist/index";
    }
}