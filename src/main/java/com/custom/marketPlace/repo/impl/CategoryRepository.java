package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.constants.Qualifiers;
import com.custom.marketPlace.model.Category;
import com.custom.marketPlace.repo.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository(Qualifiers.CATEGORY_REPO)
public class CategoryRepository extends AbstractRepository<Category> {

    public CategoryRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Category findById(UUID id) {
        return em.find(Category.class, id);
    }
}
