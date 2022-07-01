package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.model.Profile;
import com.custom.marketPlace.model.User;
import com.custom.marketPlace.repo.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository
public class ProfileRepository extends AbstractRepository<Profile> {

    public ProfileRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Profile findById(UUID id) {
        return em.find(Profile.class, id);
    }
}
