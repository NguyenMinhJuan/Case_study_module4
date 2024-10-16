package com.codegym.casestudymodule4.service.product;

import com.codegym.casestudymodule4.model.Coupon;
import com.codegym.casestudymodule4.model.DTO.ProductDTO;
import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findByNameContainingIgnoreCase(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Iterable<Product> findTop8ByIsPromotedTrue() {
        return productRepository.findTop8ByIsPromotedTrue();
    }

    @Override
    public List<ProductDTO> findTop8MostPurchasedProducts() {
        return  productRepository.findTop8MostPurchasedProducts();
    }

}

