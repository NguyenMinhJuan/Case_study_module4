package com.codegym.casestudymodule4.service.index;

import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.repository.IndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IndexService implements IIndexService {
    @Autowired
    IndexRepository indexRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return indexRepository.findAll(pageable);
    }
}
