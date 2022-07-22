package com.custom.marketPlace.services.impl;

import com.custom.marketPlace.database.constants.Qualifiers;
import com.custom.marketPlace.model.Attribute;
import com.custom.marketPlace.repo.IRepository;
import com.custom.marketPlace.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(Qualifiers.ATTRIBUTE_SERVICE)
public class AttributeService extends AbstractService<Attribute> {

    @Autowired
    public AttributeService(@Qualifier(Qualifiers.ATTRIBUTE_REPO) IRepository<Attribute> repository) {
        super(repository);
    }
}
