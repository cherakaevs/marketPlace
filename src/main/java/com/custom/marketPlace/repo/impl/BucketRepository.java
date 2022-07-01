package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.model.Bucket;
import com.custom.marketPlace.repo.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.UUID;

public class BucketRepository extends AbstractRepository<Bucket> {

    public BucketRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Bucket findById(UUID id) {
        return em.find(Bucket.class, id);
    }
}
