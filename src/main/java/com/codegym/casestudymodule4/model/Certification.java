package com.codegym.casestudymodule4.model;

import com.codegym.casestudymodule4.model.ENUM.CertificationStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "certifications")
@Data
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private String certificationName;

    private LocalDate issueDate;

    private LocalDate expiryDate;

    private String issuedBy;
    @Enumerated(EnumType.STRING)
    private CertificationStatus status;
}