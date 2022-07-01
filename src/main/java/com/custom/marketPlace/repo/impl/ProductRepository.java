package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.model.Product;
import com.custom.marketPlace.repo.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.UUID;

public class ProductRepository extends AbstractRepository<Product> {

    public ProductRepository(EntityManager em){
        super(em);
    }

    @Override
    public Product findById(UUID id) {
        return em.find(Product.class, id);
    }
}
