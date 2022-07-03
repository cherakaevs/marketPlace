package com.custom.marketPlace.services.impl;

import com.custom.marketPlace.constants.Qualifiers;
import com.custom.marketPlace.model.Profile;
import com.custom.marketPlace.repo.IRepository;
import com.custom.marketPlace.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(Qualifiers.PROFILE_SERVICE)
public class ProfileService extends AbstractService<Profile> {

    @Autowired
    public ProfileService(@Qualifier(Qualifiers.PROFILE_REPO) IRepository<Profile> repository) {
        super(repository);
    }
}
