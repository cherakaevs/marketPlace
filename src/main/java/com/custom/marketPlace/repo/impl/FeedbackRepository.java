package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.database.constants.Qualifiers;
import com.custom.marketPlace.model.Feedback;
import com.custom.marketPlace.repo.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository(Qualifiers.FEEDBACK_REPO)
public class FeedbackRepository extends AbstractRepository<Feedback> {

    public FeedbackRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Feedback findById(UUID id) {
        return em.find(Feedback.class, id);
    }
}
