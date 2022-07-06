package com.custom.marketPlace.security.controllers;

import com.custom.marketPlace.security.model.LoginResponseMessage;
import com.custom.marketPlace.security.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/auth/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<LoginResponseMessage> login(@RequestParam("email") String email, @RequestParam("pass") String pass) throws Exception {
        LoginResponseMessage responseMessage = authService.login(email, pass);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseMessage);
    }
}
