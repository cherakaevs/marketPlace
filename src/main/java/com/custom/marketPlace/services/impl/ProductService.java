package com.custom.marketPlace.services.impl;

import com.custom.marketPlace.database.constants.Qualifiers;
import com.custom.marketPlace.model.Product;
import com.custom.marketPlace.repo.IRepository;
import com.custom.marketPlace.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(Qualifiers.PRODUCT_SERVICE)
public class ProductService extends AbstractService<Product> {

    @Autowired
    public ProductService(@Qualifier(Qualifiers.PRODUCT_REPO) IRepository<Product> repository) {
        super(repository);
    }
}
