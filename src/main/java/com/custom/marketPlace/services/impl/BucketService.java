package com.custom.marketPlace.services.impl;

import com.custom.marketPlace.constants.Qualifiers;
import com.custom.marketPlace.model.Bucket;
import com.custom.marketPlace.repo.IRepository;
import com.custom.marketPlace.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(Qualifiers.BUCKET_SERVICE)
public class BucketService extends AbstractService<Bucket> {

    @Autowired
    public BucketService(@Qualifier(Qualifiers.BUCKET_REPO) IRepository<Bucket> repository) {
        super(repository);
    }
}
