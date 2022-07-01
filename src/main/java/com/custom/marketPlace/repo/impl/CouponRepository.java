package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.model.Coupon;
import com.custom.marketPlace.repo.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.UUID;

public class CouponRepository extends AbstractRepository<Coupon> {

    public CouponRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Coupon findById(UUID id) {
        return em.find(Coupon.class, id);
    }
}
