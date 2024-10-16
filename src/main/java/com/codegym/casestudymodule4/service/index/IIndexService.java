package com.codegym.casestudymodule4.service.index;

import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IIndexService {
    Page<Product> findAll(Pageable pageable);
}
