package com.codegym.casestudymodule4.controller.user;

import com.codegym.casestudymodule4.model.User;
import com.codegym.casestudymodule4.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Hiển thị form đăng ký
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());  // Đối tượng user rỗng
        return "/user/register_user";
    }

    // Xử lý đăng ký
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
            userService.registerUser(user);
            return "redirect:/users/login";  // Điều hướng tới trang login nếu đăng ký thành công
        } catch (IllegalArgumentException e) {
            // Nếu có lỗi, đưa thông báo lỗi lên giao diện
            model.addAttribute("errorMessage", e.getMessage());
            return "/user/register_user";  // Quay lại trang đăng ký nếu có lỗi
        }
    }

    // Hiển thị form đăng nhập
    @GetMapping("/login")
    public String showLoginForm() {
        return "/user/login";
    }

    // Hiển thị thông tin cá nhân
    @GetMapping("/profile")
    public String showUserProfile(Model model) {
        User currentUser = userService.getCurrentUser();
        model.addAttribute("user", currentUser);
        return "/user/user_profile";
    }

    // Hiển thị form cập nhật
    @GetMapping("/edit")
    public String showUpdateForm(Model model) {
        User currentUser = userService.getCurrentUser();
        model.addAttribute("user", currentUser);
        return "/user/edit_user";
    }

    // Cập nhật thông tin cá nhân
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users/profile";
    }
    // Hiển thị trang chính, đẩy thông tin user vào view
    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("username", user.getUsername());
        }
        return "/organic-1.0.0/index"; // trả về trang index.html
    }

    // Trang thông tin cá nhân
    @GetMapping("/user/profile")
    public String profile(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("username", user.getUsername());
            // Thêm các thông tin khác nếu cần
        }
        return "/user/user_profile"; // trả về trang profile.html cho thông tin cá nhân
    }
}