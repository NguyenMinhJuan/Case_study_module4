package com.codegym.casestudymodule4.service.user;

import com.codegym.casestudymodule4.model.User;
import com.codegym.casestudymodule4.service.IGenerateService;
import jakarta.persistence.GeneratedValue;

import java.util.Optional;

public interface IUseService extends IGenerateService<User> {
    Optional<User> findByUsername(String username);
}
