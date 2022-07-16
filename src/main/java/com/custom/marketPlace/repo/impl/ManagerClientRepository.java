package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.constants.Qualifiers;
import com.custom.marketPlace.model.ManagerClient;
import com.custom.marketPlace.repo.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository(Qualifiers.MANAGER_CLIENT_REPO)
public class ManagerClientRepository extends AbstractRepository<ManagerClient> {

    public ManagerClientRepository(EntityManager em) {
        super(em);
    }

    @Override
    public ManagerClient findById(UUID id) {
        return em.find(ManagerClient.class, id);
    }

    public ManagerClient findByClientId(String clientID){
        return (ManagerClient) em.createNativeQuery("SELECT * FROM manager_client mc WHERE mc.clientId ='users-management-client' ").getSingleResult();
    }
}
