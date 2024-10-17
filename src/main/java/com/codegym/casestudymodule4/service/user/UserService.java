package com.codegym.casestudymodule4.service.user;

import com.codegym.casestudymodule4.model.ENUM.ROLE;
import com.codegym.casestudymodule4.model.User;
import com.codegym.casestudymodule4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Tên đăng nhập đã tồn tại.");
        }

        // Kiểm tra xem email đã tồn tại chưa
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email đã tồn tại.");
        }

        // Kiểm tra xem số điện thoại đã tồn tại chưa
        if (userRepository.findByPhoneNumber(user.getPhoneNumber()).isPresent()) {
            throw new IllegalArgumentException("Số điện thoại đã tồn tại.");
        }
        // Mã hóa mật khẩu
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Đặt mặc định role là USER nếu không được chọn trong form
        if (user.getRole() == null) {
            user.setRole(ROLE.ROLE_USER);
        }

        // Đặt trạng thái mặc định là ACTIVE
        user.setStatus(com.codegym.casestudymodule4.model.ENUM.AccountStatus.ACTIVE);

        // Lưu người dùng vào cơ sở dữ liệu
        return userRepository.save(user);
    }

    // Cập nhật thông tin người dùng
    public User updateUser(User updatedUser) {
        User existingUser = getCurrentUser();
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        if (!updatedUser.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));  // Mã hóa mật khẩu mới nếu có
        }
        return userRepository.save(existingUser);
    }


    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + username));
    }
}

