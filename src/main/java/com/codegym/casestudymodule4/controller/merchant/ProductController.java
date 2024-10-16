package com.codegym.casestudymodule4.controller.merchant;

import com.codegym.casestudymodule4.model.Merchant;
import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.service.merchant.MerchantService;
import com.codegym.casestudymodule4.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/merchant/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private MerchantService merchantService;

    @GetMapping("/list")
    public String getProducts(Model model) {
        Iterable<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/merchant/products/list";
    }

    @GetMapping("/create")
    public String createProductForm(Model model) {
        List<Merchant> merchants = merchantService.findAll();
        model.addAttribute("merchants", merchants);
        model.addAttribute("product", new Product());
        return "/merchant/products/create";
    }

    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/merchant/products/list";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "merchant/products/edit";
        }
        return "redirect:/merchant/products"; // Redirect if not found
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setProductId(id);
        productService.save(product);
        return "redirect:/merchant/products/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.remove(id);
        return "redirect:/merchant/products/list";
    }
}

