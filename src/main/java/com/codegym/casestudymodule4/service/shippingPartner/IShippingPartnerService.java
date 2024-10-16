package com.codegym.casestudymodule4.service.shippingPartner;

import com.codegym.casestudymodule4.model.ShippingPartner;
import com.codegym.casestudymodule4.service.IGenerateService;

public interface IShippingPartnerService extends IGenerateService<ShippingPartner> {
     void lockShippingPartner(Long id);
     void unlockShippingPartner(Long id);
}
