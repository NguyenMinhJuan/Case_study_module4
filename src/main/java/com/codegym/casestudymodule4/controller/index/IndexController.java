package com.codegym.casestudymodule4.controller.index;

import com.codegym.casestudymodule4.model.Category;
import com.codegym.casestudymodule4.model.DTO.ProductDTO;
import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.service.category.ICategoryService;
import com.codegym.casestudymodule4.service.product.IProductService;
import com.codegym.casestudymodule4.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.plaf.PanelUI;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute
    public void addAttributes(Model model) {
        Iterable<Product> products = productService.findAll();
        Iterable<Category> categories = categoryService.findAll();
        Iterable<ProductDTO> productMostUser= productService.findTop8MostPurchasedProducts();
        Iterable<Product> productsPromotes= productService.findTop8ByIsPromotedTrue();
        model.addAttribute("productsPromotes",productsPromotes);
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("productMostUser", productMostUser);
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView modelAndView= new ModelAndView("index/index");
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

//    @GetMapping("products/{id}/view")
//    public ModelAndView showViewProduct(@PathVariable("id") Long id){
//        ModelAndView modelAndView = new ModelAndView("/product/view");
//        Optional<Product> product = productService.findById(id);
//        modelAndView.addObject("product", product.get());
//        return  modelAndView;
//    }

}