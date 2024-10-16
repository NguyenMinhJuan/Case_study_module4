package com.codegym.casestudymodule4.controller.admin;//package com.codegym.casestudymodule4.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public ModelAndView showAdminDashboard() {
        ModelAndView modelAndView = new ModelAndView("admin/index");
        return modelAndView;
    }
}
