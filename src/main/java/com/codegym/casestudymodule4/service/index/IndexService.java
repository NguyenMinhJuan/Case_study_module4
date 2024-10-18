package com.codegym.casestudymodule4.service.index;

import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.repository.IIndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IndexService implements IIndexService {
    @Autowired
    IIndexRepository IIndexRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return IIndexRepository.findAll(pageable);
    }
}
