package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.model.Category;
import com.custom.marketPlace.repo.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.UUID;

public class CategoryRepository extends AbstractRepository<Category> {

    public CategoryRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Category findById(UUID id) {
        return em.find(Category.class, id);
    }
}
