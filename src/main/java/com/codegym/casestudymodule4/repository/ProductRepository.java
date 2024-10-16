package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.DTO.ProductDTO;
import com.codegym.casestudymodule4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Iterable<Product> findByNameContainingIgnoreCase(String name);
    Iterable<Product> findTop8ByIsPromotedTrue();
    @Query(value = "CALL GetTop8MostPurchasedProducts()", nativeQuery = true)
    List<ProductDTO> findTop8MostPurchasedProducts();
    Iterable<Product> findByCategoryId(Long id);

}
