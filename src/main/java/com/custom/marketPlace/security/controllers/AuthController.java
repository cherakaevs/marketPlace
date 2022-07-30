package com.custom.marketPlace.security.controllers;

import com.custom.marketPlace.constants.Api;
import com.custom.marketPlace.constants.RequestParams;
import com.custom.marketPlace.constants.Views;
import com.custom.marketPlace.model.Profile;
import com.custom.marketPlace.model.User;
import com.custom.marketPlace.security.constants.PreAuthorizeRoles;
import com.custom.marketPlace.security.model.ManagerClient;
import com.custom.marketPlace.security.model.OAuth2Token;
import com.custom.marketPlace.security.services.AuthService;
import com.custom.marketPlace.security.services.ManagerClientService;
import com.custom.marketPlace.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

import static com.custom.marketPlace.security.constants.SecurityClientManagers.USER_MANAGEMENT_CLIENT;

@Controller
public class AuthController {

    private final IService<User> userIService;
    private final IService<ManagerClient> managerClientIService;
    private final AuthService authService;

    @Autowired
    public AuthController(IService<User> userIService,
                          IService<ManagerClient> managerClientIService,
                          AuthService authService) {
        this.userIService = userIService;
        this.managerClientIService = managerClientIService;
        this.authService = authService;
    }

    @GetMapping(Api.REGISTRATION)
    @PreAuthorize(PreAuthorizeRoles.ALL)
    public String registration(){
        return Views.REGISTRATION;
    }

    @PostMapping(Api.REGISTRATION)
    @PreAuthorize(PreAuthorizeRoles.ALL)
    public String registration(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String confirmPassword){
        if(password.equals(confirmPassword)) {

            Profile profile = Profile.builder().firstName(name).lastName(name).build();
            profile.setId(UUID.randomUUID());
            User user = User.builder().username(name).password(password).passwordConfirm(confirmPassword).build();
            user.setProfile(profile);
            user.setId(profile.getId());
            profile.setUser(user);
            userIService.saveEntity(user);

            ManagerClient usersManager =
                    ((ManagerClientService) managerClientIService).getByClientId(USER_MANAGEMENT_CLIENT);
            OAuth2Token token = authService.getClientToken(usersManager.getClientId(), usersManager.getSecret());
            authService.createUser(name, name, email, name, token.getAccessToken());
        }
        return Views.REDIRECT_TO_HOME;
    }

    @PostMapping(Api.LOGIN)
    @PreAuthorize(PreAuthorizeRoles.ALL)
    public ResponseEntity<OAuth2Token> login(@RequestParam(RequestParams.EMAIL) String email,
                                             @RequestParam(RequestParams.PASSWORD) String pass) throws Exception {
        OAuth2Token responseMessage = authService.login(email, pass);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseMessage);
    }

}
