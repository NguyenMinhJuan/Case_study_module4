package com.codegym.casestudymodule4.controller.admin;


import com.codegym.casestudymodule4.model.ShippingPartner;
import com.codegym.casestudymodule4.service.product.IProductService;
import com.codegym.casestudymodule4.service.shippingPartner.IShippingPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ShippingPartnerController {
    @Autowired
    private IShippingPartnerService shippingPartnerService;
    @Autowired
    private IProductService productService;
    @GetMapping("/shippingPartner/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("admin/shippingPartner/list");
        Iterable<ShippingPartner> shippingPartners = shippingPartnerService.findAll();
        modelAndView.addObject("shippingPartners",shippingPartners);
        return modelAndView;
    }
    @GetMapping("/shippingPartner/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("admin/shippingPartner/create");
        ShippingPartner shippingPartner = new ShippingPartner();
        shippingPartner.setIsLocked(false); // Hoặc true, tùy thuộc vào logic của bạn
        modelAndView.addObject("shippingPartner", shippingPartner);
        return modelAndView;
    }

    @PostMapping("/shippingPartner/save")
    public ModelAndView save(ShippingPartner shippingPartner) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/shippingPartner/list");
        shippingPartnerService.save(shippingPartner);
        return modelAndView;
    }

    @GetMapping("/shippingPartner/{id}/update")
    public ModelAndView formUpdate(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/shippingPartner/update");
        Optional<ShippingPartner> shippingPartner = shippingPartnerService.findById(id);
        modelAndView.addObject("shippingPartner", shippingPartner.get());
        return modelAndView;
    }

    @PostMapping("/shippingPartner/update")
    public ModelAndView update(ShippingPartner shippingPartner) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/shippingPartner/list");
        shippingPartnerService.save(shippingPartner);
        return modelAndView;
    }

    @GetMapping("/shippingPartner/{id}/delete")
    public ModelAndView formDelete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/shippingPartner/delete");
        Optional<ShippingPartner> shippingPartner = shippingPartnerService.findById(id);
        if (shippingPartner.isPresent()) {
            modelAndView.addObject("shippingPartner", shippingPartner.get()); // Lấy đối tượng
        } else {
            modelAndView.addObject("error", "Đối tác vận chuyển không tồn tại.");
        }
        return modelAndView;
    }

    @PostMapping("/shippingPartner/delete")
    public ModelAndView delete(@ModelAttribute("shippingPartner") ShippingPartner shippingPartner) {
        shippingPartnerService.remove(shippingPartner.getId());
        return new ModelAndView("redirect:/admin/shippingPartner/list");
    }

    @PostMapping("/shippingPartner/{id}/lock")
    public ModelAndView lock(@PathVariable("id") Long id) {
        shippingPartnerService.lockShippingPartner(id);
        return new ModelAndView("redirect:/admin/shippingPartner/list");
    }

    @PostMapping("/shippingPartner/{id}/unlock")
    public ModelAndView unlock(@PathVariable("id") Long id) {
        shippingPartnerService.unlockShippingPartner(id);
        return new ModelAndView("redirect:/admin/shippingPartner/list");
    }
//    @GetMapping("products/search")
//    public ModelAndView searchNameProduct (@RequestParam(value = "name", required = false, defaultValue = "") String name){
//        Iterable<Product> products = productService.findByNameContainingIgnoreCase(name);
//        ModelAndView modelAndView = new ModelAndView("product/list");
//        modelAndView.addObject("products", products);
//        return modelAndView;
//    }
//    @GetMapping("products/promoted")
//    public ModelAndView listPromotedProducts() {
//        ModelAndView modelAndView = new ModelAndView("product/list1");
//        Iterable<Product> promotedProducts = productService.findTop8ByIsPromotedTrue();
//        modelAndView.addObject("promotedProducts", promotedProducts);
//        return modelAndView;
//    }
//    @GetMapping("products/{id}/view")
//    public ModelAndView showViewProduct(@PathVariable("id") Long id){
//        ModelAndView modelAndView = new ModelAndView("/product/view");
//        Optional<Product> product = productService.findById(id);
//        modelAndView.addObject("product", product.get());
//        return  modelAndView;
//    }

}
