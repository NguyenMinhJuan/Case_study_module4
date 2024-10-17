package com.codegym.casestudymodule4.controller.admin;//package com.codegym.casestudymodule4.controller;

import com.codegym.casestudymodule4.model.*;
import com.codegym.casestudymodule4.model.DTO.CouponDTO;
import com.codegym.casestudymodule4.model.DTO.OrderDTO;
import com.codegym.casestudymodule4.model.ENUM.OrderStatus;
import com.codegym.casestudymodule4.service.certification.ICertificationService;
import com.codegym.casestudymodule4.service.order.IOrderService;
import com.codegym.casestudymodule4.service.product.IProductService;
import com.codegym.casestudymodule4.service.user.IUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICertificationService certificationService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IUseService userService;

    @GetMapping
    public ModelAndView showAdminDashboard() {
        ModelAndView modelAndView = new ModelAndView("admin/index");
        return modelAndView;
    }

    @GetMapping("/products/list")
    public ModelAndView showListProduct() {
        Iterable<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("admin/product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/products/{id}/view")
    public ModelAndView showViewProduct(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("admin/product/view");
        List<Certification> certifications = certificationService.findByProductProductId(id);
        Optional<Product> product = productService.findById(id);
        List<CouponDTO> coupons = productService.getCouponsByProduct(id);
        modelAndView.addObject("product", product.get());
        modelAndView.addObject("coupons", coupons);
        modelAndView.addObject("certifications", certifications);
        modelAndView.addObject("orderItem", new OrderItem());
        return modelAndView;
    }
    @PostMapping("/products/{id}/addToCart")
    public ModelAndView addToCart(@PathVariable("id") Long id,
                                  @RequestParam("quantity") Integer quantity,
                                  Principal principal) {
        // Tạo OrderDTO từ thông tin cần thiết
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setProductId(id); // Sản phẩm ID từ URL
        orderDTO.setUserId(userService.findByUsername(principal.getName()).get().getUserId()); // Lấy ID người dùng từ principal
        orderDTO.setQuantity(quantity); // Số lượng sản phẩm từ yêu cầu

        // Tạo đơn hàng qua OrderService
        Order order = orderService.createOrder(orderDTO);

        ModelAndView modelAndView = new ModelAndView("admin/product/cart");
        modelAndView.addObject("order", order); // Gửi đơn hàng tới view
        return modelAndView;
    }


}
