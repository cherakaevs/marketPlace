package com.custom.marketPlace.security.controllers;

import com.custom.marketPlace.constants.Api;
import com.custom.marketPlace.model.Profile;
import com.custom.marketPlace.model.User;
import com.custom.marketPlace.security.model.LoginResponseMessage;
import com.custom.marketPlace.security.model.ManagerClient;
import com.custom.marketPlace.security.services.AuthService;
import com.custom.marketPlace.security.services.ManagerClientService;
import com.custom.marketPlace.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

import static com.custom.marketPlace.security.constants.SecurityClientManagers.USER_MANAGEMENT_CLIENT;
import static org.keycloak.OAuth2Constants.*;

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
    public String registration(Model model){
        return "registration";
    }

    @PostMapping(Api.REGISTRATION)
    public String registration(@RequestParam String name, @RequestParam String email, @RequestParam String password,
                               @RequestParam String confirmPassword, Model model){
        if(password.equals(confirmPassword)) {

            Profile profile = Profile.builder().firstName(name).lastName(name).build();
            profile.setId(UUID.randomUUID());
            User user = User.builder().username(name).password(password).passwordConfirm(confirmPassword).build();
            user.setProfile(profile);
            user.setId(profile.getId());
            profile.setUser(user);
            userIService.saveEntity(user);

            // TODO: получение токена лучше вынести в сервис какой-нибудь. Бачу сервис AuthService. Можно оттуда счиздить
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            ManagerClient usersManager =
                    ((ManagerClientService) managerClientIService).getByClientId(USER_MANAGEMENT_CLIENT);

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add(GRANT_TYPE, CLIENT_CREDENTIALS);
            map.add(CLIENT_ID, usersManager.getClientId());
            map.add(CLIENT_SECRET, usersManager.getSecret());

            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
            // TODO: получение токена лучше вынести в сервис какой-нибудь. Бачу сервис AuthService. Можно оттуда счиздить

            ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:7432/realms/market-place/protocol/openid-connect/token",
                    entity, String.class);
            // ============================================================
        }
        return "redirect:/home";
    }

    @PostMapping("/auth/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<LoginResponseMessage> login(@RequestParam("email") String email, @RequestParam("pass") String pass) throws Exception {
        LoginResponseMessage responseMessage = authService.login(email, pass);
        return ResponseEntity.status(HttpStatus.OK)
                .body(responseMessage);
    }
}
