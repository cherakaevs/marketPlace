package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.database.constants.Qualifiers;
import com.custom.marketPlace.model.Product;
import com.custom.marketPlace.repo.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository(Qualifiers.PRODUCT_REPO)
public class ProductRepository extends AbstractRepository<Product> {

    public ProductRepository(EntityManager em){
        super(em);
    }

    @Override
    public Product findById(UUID id) {
        return em.find(Product.class, id);
    }
}
