package com.codegym.casestudymodule4.controller.admin;//package com.codegym.casestudymodule4.controller;
import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
@Autowired
private IProductService productService;
    @GetMapping
    public ModelAndView showAdminDashboard() {
        ModelAndView modelAndView = new ModelAndView("admin/index");
        return modelAndView;
    }
    @GetMapping("/products/list")
        public ModelAndView showListProduct(){
        Iterable<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("admin/product/list");
        modelAndView.addObject("products",products);
        return  modelAndView;
        }
    @GetMapping("/products/{id}/view")
    public ModelAndView showViewProduct(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("admin/product/view");
        Optional<Product> product = productService.findById(id);
        modelAndView.addObject("product", product.get());
        return  modelAndView;
    }
}
