package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.model.Feedback;
import com.custom.marketPlace.repo.AbstractRepository;

import javax.persistence.EntityManager;
import java.util.UUID;

public class FeedbackRepository extends AbstractRepository<Feedback> {

    public FeedbackRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Feedback findById(UUID id) {
        return em.find(Feedback.class, id);
    }
}
