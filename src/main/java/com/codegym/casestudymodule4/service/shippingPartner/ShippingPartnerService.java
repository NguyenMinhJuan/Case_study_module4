package com.codegym.casestudymodule4.service.shippingPartner;

import com.codegym.casestudymodule4.model.ShippingPartner;
import com.codegym.casestudymodule4.repository.ShippingPartnerRepository;
import com.codegym.casestudymodule4.service.IGenerateService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippingPartnerService implements IShippingPartnerService{
@Autowired
private ShippingPartnerRepository shippingPartnerRepository;
    @Override
    public Iterable<ShippingPartner> findAll() {
        return shippingPartnerRepository.findAll();
    }

    @Override
    public Optional<ShippingPartner> findById(Long id) {
        return shippingPartnerRepository.findById(id);
    }

    @Override
    public ShippingPartner save(ShippingPartner shippingPartner) {
        return shippingPartnerRepository.save(shippingPartner);
    }

    @Override
    public void remove(Long id) {
           shippingPartnerRepository.deleteById(id);
    }

    @Override
    public void lockShippingPartner(Long id) {
        Optional<ShippingPartner> shippingPartner = shippingPartnerRepository.findById(id);
        if (shippingPartner.isPresent()) {
            ShippingPartner partner = shippingPartner.get();
            partner.setIsLocked(true);
            shippingPartnerRepository.save(partner);
        }
    }

    @Override
    public void unlockShippingPartner(Long id) {
        Optional<ShippingPartner> shippingPartner = shippingPartnerRepository.findById(id);
        if (shippingPartner.isPresent()) {
            ShippingPartner partner = shippingPartner.get();
            partner.setIsLocked(false);
            shippingPartnerRepository.save(partner);
        }
    }
}
