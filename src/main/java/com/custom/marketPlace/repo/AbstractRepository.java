package com.custom.marketPlace.repo;

import com.custom.marketPlace.model.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
public abstract class AbstractRepository<ObjectClass extends BaseEntity> implements IRepository<ObjectClass> {

    protected final EntityManager em;

    @Autowired
    public AbstractRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(ObjectClass object) {
        em.persist(object);
    }

    @Override
    @Transactional
    public void update(ObjectClass object) {
        ObjectClass objectInContext = findById(object.getId());
        if (em.contains(objectInContext)) {
            em.merge(objectInContext);
            return;
        }
        throw new RuntimeException("Could not update entity in database: object is detached");
    }

    @Override
    @Transactional
    public void delete(ObjectClass object) {
        ObjectClass objectInContext = findById(object.getId());
        if (em.contains(objectInContext)) {
            em.remove(objectInContext);
            return;
        }
        throw new RuntimeException("Could not remove entity from database: object is detached");
    }

    @Override
    public abstract ObjectClass findById(UUID id);

}
