package com.codegym.casestudymodule4.service.merchant;

import com.codegym.casestudymodule4.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {
    @Autowired
    IMerchantRepository IMerchantRepository;

    public List<Merchant> findAll() {
        return (List<Merchant>) IMerchantRepository.findAll();
    }
}
