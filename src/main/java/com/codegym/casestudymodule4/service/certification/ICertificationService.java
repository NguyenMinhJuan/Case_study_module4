package com.codegym.casestudymodule4.service.certification;

import com.codegym.casestudymodule4.model.Certification;

import java.util.List;

public interface ICertificationService {
    List<Certification> findByProductProductId(Long id);
}
