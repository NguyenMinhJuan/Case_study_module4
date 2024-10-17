package com.codegym.casestudymodule4.service.certification;

import com.codegym.casestudymodule4.model.Certification;
import com.codegym.casestudymodule4.repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CertificationService implements ICertificationService{
    @Autowired
    private CertificationRepository certificationRepository;
    @Override
    public List<Certification> findByProductProductId(Long id) {
        return certificationRepository.findByProductProductId(id);
    }
}
