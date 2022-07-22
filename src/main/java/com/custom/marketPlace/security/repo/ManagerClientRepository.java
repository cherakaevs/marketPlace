package com.custom.marketPlace.security.repo;

import com.custom.marketPlace.database.constants.Qualifiers;
import com.custom.marketPlace.database.constants.QueriesNames;
import com.custom.marketPlace.security.model.ManagerClient;
import com.custom.marketPlace.repo.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository(Qualifiers.MANAGER_CLIENT_REPO)
public class ManagerClientRepository extends AbstractRepository<ManagerClient> {

    private static final String CLIENT_ID = "client_id";

    public ManagerClientRepository(EntityManager em) {
        super(em);
    }

    @Override
    public ManagerClient findById(UUID id) {
        return em.find(ManagerClient.class, id);
    }

    public ManagerClient findByClientId(String clientID){
        return em.createNamedQuery(QueriesNames.GET_MANAGER_CLIENT_BY_CLIENT_ID, ManagerClient.class)
                .setParameter(CLIENT_ID, clientID).getSingleResult();
    }
}
