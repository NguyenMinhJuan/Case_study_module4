package com.codegym.casestudymodule4.service.product;
import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository IProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return IProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return IProductRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return IProductRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        IProductRepository.deleteById(id);
    }
}

