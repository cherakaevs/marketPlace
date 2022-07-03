package com.custom.marketPlace.services.impl;

import com.custom.marketPlace.constants.Qualifiers;
import com.custom.marketPlace.model.Category;
import com.custom.marketPlace.repo.IRepository;
import com.custom.marketPlace.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(Qualifiers.CATEGORY_SERVICE)
public class CategoryService extends AbstractService<Category> {

    @Autowired
    public CategoryService(@Qualifier(Qualifiers.CATEGORY_REPO) IRepository<Category> repository) {
        super(repository);
    }
}
