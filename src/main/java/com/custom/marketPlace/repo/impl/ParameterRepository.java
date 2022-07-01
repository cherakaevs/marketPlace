package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.model.Parameter;
import com.custom.marketPlace.repo.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.UUID;

public class ParameterRepository extends AbstractRepository<Parameter> {

    public ParameterRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Parameter findById(UUID id) {
        return em.find(Parameter.class, id);
    }
}
