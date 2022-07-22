package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.database.constants.Qualifiers;
import com.custom.marketPlace.model.Address;
import com.custom.marketPlace.repo.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository(Qualifiers.ADDRESS_REPO)
public class AddressRepository extends AbstractRepository<Address> {

    public AddressRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Address findById(UUID id) {
        return em.find(Address.class, id);
    }
}
