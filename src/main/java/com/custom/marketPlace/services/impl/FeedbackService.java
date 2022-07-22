package com.custom.marketPlace.services.impl;

import com.custom.marketPlace.database.constants.Qualifiers;
import com.custom.marketPlace.model.Feedback;
import com.custom.marketPlace.repo.IRepository;
import com.custom.marketPlace.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(Qualifiers.FEEDBACK_SERVICE)
public class FeedbackService extends AbstractService<Feedback> {

    @Autowired
    public FeedbackService(@Qualifier(Qualifiers.FEEDBACK_REPO) IRepository<Feedback> repository) {
        super(repository);
    }
}
