package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.enums.PossibleValues;
import com.custom.marketPlace.model.Attribute;
import com.custom.marketPlace.model.Order;
import com.custom.marketPlace.repo.AttribureRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.UUID;

public class AttributeRepositoryImpl implements AttribureRepository {
    private EntityManager em;

    public AttributeRepositoryImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public Attribute getAttributeById(UUID id) {
        return em.find(Attribute.class, id);
    }

    @Override
    public Attribute getAttributeByName(String name) {
        TypedQuery<Attribute> q = em.createQuery("SELECT a FROM Attribute a where a.name = :name", Attribute.class);
        q.setParameter("name", name);
        return q.getSingleResult();
    }

    @Override
    public Attribute saveAttribute(Attribute a) {
        if (a.getId() == null) {
            em.persist(a);
        } else {
            a = em.merge(a);
        }
        return a;
    }

    @Override
    public void removeAttribute(Attribute a) {
        if (em.contains(a)) {
            em.remove(a);
        } else {
            em.merge(a);
        }
    }

    @Override
    public void updateAttributeName(UUID id, String name) {
        TypedQuery<Attribute> q = em.createQuery("UPDATE Attribute a SET  a.name= :name where a.id = :id", Attribute.class);
        q.setParameter("id", id);
        q.setParameter("name", name);
    }

    @Override
    public void updateAttributePossibleValues(UUID id, PossibleValues values) {
        TypedQuery<Attribute> q = em.createQuery("UPDATE Attribute a SET  a.values=:values where a.id = :id", Attribute.class);
        q.setParameter("id", id);
        q.setParameter("values", values);
    }
}
