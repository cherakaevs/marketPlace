package com.custom.marketPlace.services.impl;

import com.custom.marketPlace.database.constants.Qualifiers;
import com.custom.marketPlace.model.Coupon;
import com.custom.marketPlace.repo.IRepository;
import com.custom.marketPlace.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(Qualifiers.COUPON_SERVICE)
public class CouponService extends AbstractService<Coupon> {

    @Autowired
    public CouponService(@Qualifier(Qualifiers.COUPON_REPO) IRepository<Coupon> repository) {
        super(repository);
    }
}
