package com.codegym.casestudymodule4.service.merchant;

import com.codegym.casestudymodule4.model.Merchant;
import org.springframework.data.repository.CrudRepository;

public interface IMerchantRepository extends CrudRepository<Merchant, Long> {
}
