package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.model.Order;
import com.custom.marketPlace.model.Parameter;
import com.custom.marketPlace.repo.ParameterRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.UUID;

public class ParameterRepositoryImpl implements ParameterRepository {
    private EntityManager em;

    public ParameterRepositoryImpl(EntityManager em){
        this.em = em;
    }
    @Override
    public Parameter getParameterById(UUID id) {
        return em.find(Parameter.class, id);
    }

    @Override
    public Parameter getParameterByValue(String value) {
        TypedQuery<Parameter> q = em.createQuery("SELECT p FROM Parameter p where p.value = :value", Parameter.class);
        q.setParameter("value", value);
        return q.getSingleResult();
    }

    @Override
    public Parameter saveParameter(Parameter p) {
        if (p.getId() == null) {
            em.persist(p);
        } else {
            p = em.merge(p);
        }
        return p;
    }

    @Override
    public void removeParameter(Parameter p) {
        if (em.contains(p)) {
            em.remove(p);
        } else {
            em.merge(p);
        }
    }

    @Override
    public void updateParameterValue(UUID id, String value) {
        TypedQuery<Parameter> q = em.createQuery("UPDATE Parameter p SET p.value = :value where p.id = :id", Parameter.class);
        q.setParameter("id", id);
        q.setParameter("value", value);
    }
}
