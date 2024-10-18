package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIndexRepository extends JpaRepository<Product, Long> {
}
