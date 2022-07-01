package com.custom.marketPlace.services.impl;

import com.custom.marketPlace.constants.Qualifiers;
import com.custom.marketPlace.model.User;
import com.custom.marketPlace.repo.IRepository;
import com.custom.marketPlace.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(Qualifiers.USER_SERVICE)
public class UserService extends AbstractService<User> {

    @Autowired
    public UserService(IRepository<User> repository) {
        super(repository);
    }
}
