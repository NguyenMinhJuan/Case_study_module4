package com.codegym.casestudymodule4.security;

import com.codegym.casestudymodule4.service.user.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/register", "/users/login","css/**","fonts/**","js/**","css/**","images/**").permitAll()  // Cho phép truy cập trang đăng ký và đăng nhập mà không cần đăng nhập trước
                        .anyRequest().authenticated()  // Yêu cầu xác thực cho các yêu cầu khác
                )
                .formLogin(form -> form
                        .loginPage("/users/login")  // Trang đăng nhập tùy chỉnh
                        .loginProcessingUrl("/login")  // URL để xử lý quá trình đăng nhập
                        .defaultSuccessUrl("/index", true)  // Chuyển hướng đến trang profile sau khi đăng nhập thành công
                        .failureUrl("/users/login?error=true")  // Điều hướng đến trang login với thông báo lỗi nếu đăng nhập thất bại
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")  // Đường dẫn để đăng xuất
                        .logoutSuccessUrl("/users/login?logout")  // Chuyển hướng về trang login sau khi đăng xuất thành công
                        .invalidateHttpSession(true)  // Hủy session của người dùng
                        .deleteCookies("JSESSIONID")  // Xóa cookie phiên
                        .permitAll()
                )
                .userDetailsService(customUserDetailsService)  // Sử dụng UserDetailsService để xác thực
                .sessionManagement(session -> session
                        .maximumSessions(1)  // Chỉ cho phép một phiên đăng nhập cùng lúc
                        .maxSessionsPreventsLogin(false)
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Mã hóa mật khẩu với BCrypt
    }
}