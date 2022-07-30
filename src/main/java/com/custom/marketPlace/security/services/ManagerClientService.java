package com.custom.marketPlace.security.services;

import com.custom.marketPlace.database.constants.Qualifiers;
import com.custom.marketPlace.repo.IRepository;
import com.custom.marketPlace.security.model.ManagerClient;
import com.custom.marketPlace.security.repo.ManagerClientRepository;
import com.custom.marketPlace.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(Qualifiers.MANAGER_CLIENT_SERVICE)
public class ManagerClientService extends AbstractService<ManagerClient> {
    @Autowired
    public ManagerClientService(@Qualifier(Qualifiers.MANAGER_CLIENT_REPO) IRepository<ManagerClient> repository) {
        super(repository);
    }

    public ManagerClient getByClientId(String clientID){
        return ((ManagerClientRepository)repository).findByClientId(clientID);
    }
}
