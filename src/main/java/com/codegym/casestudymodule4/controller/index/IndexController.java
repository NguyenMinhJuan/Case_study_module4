package com.codegym.casestudymodule4.controller.index;

import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.service.index.IndexService;
import com.codegym.casestudymodule4.service.product.ProductService;
import com.codegym.casestudymodule4.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    private IndexService indexService;

    @RequestMapping
    public String index(Model model,@PageableDefault(value = 6) Pageable pageable) {
        model.addAttribute("products", indexService.findAll(pageable));
        return "/index/index";
    }
}