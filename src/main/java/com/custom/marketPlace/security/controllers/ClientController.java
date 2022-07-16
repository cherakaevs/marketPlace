package com.custom.marketPlace.security.controllers;

import com.custom.marketPlace.security.model.ClientInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
public class ClientController {
//
    @GetMapping("/api/admin")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("test");
    }
//    @PostMapping("/client/add")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<ClientInfo> addNewClient(@Valid ClientInfo clientInfo) {
//        log.info("Call method addNewClient");
//        return ResponseEntity.status(HttpStatus.OK)
//                .body("Client add");
//    }
//
//    @GetMapping("/client/{clientId}")
//    @PreAuthorize("hasRole('USER')")
//    public ResponseEntity<ClientInfo> getClientInfoById(Integer clientId) {
//        result = clientService.getClientById(clientId);
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body("CLIENT");
//    }
}