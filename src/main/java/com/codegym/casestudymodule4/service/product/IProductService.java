package com.codegym.casestudymodule4.service.product;

import com.codegym.casestudymodule4.model.Coupon;
import com.codegym.casestudymodule4.model.DTO.ProductDTO;
import com.codegym.casestudymodule4.model.Product;
import com.codegym.casestudymodule4.service.IGenerateService;

import java.util.List;

public interface IProductService extends IGenerateService<Product> {
    Iterable<Product> findByNameContainingIgnoreCase(String name);

    Iterable<Product> findTop8ByIsPromotedTrue();

    List<ProductDTO> findTop8MostPurchasedProducts();
    Iterable<Product> findByCategoryId(Long id);
}
