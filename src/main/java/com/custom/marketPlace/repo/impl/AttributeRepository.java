package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.constants.Qualifiers;
import com.custom.marketPlace.model.Attribute;
import com.custom.marketPlace.repo.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository(Qualifiers.ATTRIBUTE_REPO)
public class AttributeRepository extends AbstractRepository<Attribute> {

    public AttributeRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Attribute findById(UUID id) {
        return em.find(Attribute.class, id);
    }
}
