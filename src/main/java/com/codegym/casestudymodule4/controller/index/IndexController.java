package com.codegym.casestudymodule4.controller.index;

import com.codegym.casestudymodule4.model.Category;
import com.codegym.casestudymodule4.model.DTO.ProductDTO;
import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.service.category.ICategoryService;
import com.codegym.casestudymodule4.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute
    public void addAttributes(Model model) {
        Iterable<Category> categories = categoryService.findAll();
        Iterable<ProductDTO> productMostUser= productService.findTop8MostPurchasedProducts();
        Iterable<Product> productsPromotes= productService.findTop8ByIsPromotedTrue();
        model.addAttribute("productsPromotes",productsPromotes);
        model.addAttribute("categories", categories);
        model.addAttribute("productMostUser", productMostUser);
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index/index");
        return modelAndView;
    }
    @GetMapping("category/filter")
    public ModelAndView filterProductsByCategory(@RequestParam("categoryId") Long categoryId) {
        ModelAndView modelAndView = new ModelAndView("index/index");
        Iterable<Product> products;
        if(categoryId==0){
            products = productService.findAll();
        }
        else {
            products = productService.findByCategoryId(categoryId);
        }
        modelAndView.addObject("products", products);
        modelAndView.addObject("selectedCategory", categoryId);
        return modelAndView;
    }
    @PostMapping("search")
    public ModelAndView searchNameProduct (@RequestParam(value = "query", required = false, defaultValue = "") String name){
        Iterable<Product> productSearch = productService.findByNameContainingIgnoreCase(name);
        ModelAndView modelAndView = new ModelAndView("/index/search");
        modelAndView.addObject("productSearch", productSearch);
        if (!productSearch.iterator().hasNext()) {
            modelAndView.addObject("message", "Không tìm thấy sản phẩm nào với tên: " + name);
        }
        return modelAndView;
    }

}