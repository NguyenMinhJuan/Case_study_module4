package com.codegym.casestudymodule4.service.user;

import com.codegym.casestudymodule4.model.User;
import com.codegym.casestudymodule4.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepository IUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = IUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Thêm "ROLE_" vào trước mỗi role
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),  // Mật khẩu đã mã hóa
                true, true, true, true,
                AuthorityUtils.createAuthorityList("ROLE_" + user.getRole().name())  // Đảm bảo vai trò có tiền tố ROLE_
        );
    }

}
