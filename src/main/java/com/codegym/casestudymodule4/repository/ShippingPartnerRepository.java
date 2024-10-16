package com.codegym.casestudymodule4.repository;

import com.codegym.casestudymodule4.model.ShippingPartner;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingPartnerRepository  extends JpaRepository<ShippingPartner,Long> {
}
