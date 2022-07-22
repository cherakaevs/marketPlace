package com.custom.marketPlace.services.impl;

import com.custom.marketPlace.database.constants.Qualifiers;
import com.custom.marketPlace.model.Address;
import com.custom.marketPlace.repo.IRepository;
import com.custom.marketPlace.services.AbstractService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(Qualifiers.ADDRESS_SERVICE)
public class AddressService extends AbstractService<Address> {

    public AddressService(@Qualifier(Qualifiers.ADDRESS_REPO) IRepository<Address> repository) {
        super(repository);
    }
}
