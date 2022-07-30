package com.custom.marketPlace.security.controllers;

import com.custom.marketPlace.constants.Api;
import com.custom.marketPlace.security.constants.PreAuthorizeRoles;
import com.custom.marketPlace.security.model.ManagerClient;
import com.custom.marketPlace.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController {
    private final IService<ManagerClient> iService;

    @Autowired
    public AdminController(IService<ManagerClient> iService) {
        this.iService = iService;
    }

    @PostMapping(Api.CLIENT_SECRETS_PAGE)
    @PreAuthorize(PreAuthorizeRoles.ADMIN)
    public ResponseEntity<String> saveSecretForUserManager(@RequestBody ManagerClient mc){
        iService.saveEntity(mc);
        return ResponseEntity.ok("Secret saved");
    }
}
