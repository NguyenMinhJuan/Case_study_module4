package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.Category;
import com.codegym.casestudymodule4.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificationRepository  extends JpaRepository<Certification, Long> {
    List<Certification> findByProductProductId(Long id);
}
