package com.custom.marketPlace.services.impl;

import com.custom.marketPlace.database.constants.Qualifiers;
import com.custom.marketPlace.model.Parameter;
import com.custom.marketPlace.repo.IRepository;
import com.custom.marketPlace.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(Qualifiers.PARAMETER_SERVICE)
public class ParameterService extends AbstractService<Parameter> {

    @Autowired
    public ParameterService(@Qualifier(Qualifiers.PARAMETER_REPO) IRepository<Parameter> repository) {
        super(repository);
    }
}
