package com.custom.marketPlace.security.controllers;

import com.custom.marketPlace.model.ManagerClient;
import com.custom.marketPlace.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController {
    @Autowired
    IService<ManagerClient> iService;

    @PostMapping("/admin")
    public ResponseEntity<String> saveSecretForUserManager(@RequestBody ManagerClient mc){
        iService.saveEntity(mc);
        return ResponseEntity.ok("Secret saved");
    }
}
