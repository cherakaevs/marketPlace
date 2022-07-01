package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.model.User;
import com.custom.marketPlace.repo.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
public class UserRepository extends AbstractRepository<User> {

    public UserRepository(EntityManager em) {
        super(em);
    }

    @Override
    public User findById(UUID id) {
        return em.find(User.class, id);
    }
}
