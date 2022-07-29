package com.custom.marketPlace.security.services;

import com.custom.marketPlace.constants.Api;
import com.custom.marketPlace.security.constants.SecurityConstants;
import com.custom.marketPlace.model.Token;
import com.custom.marketPlace.security.model.TokenInfo;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.keycloak.authorization.client.AuthorizationDeniedException;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.util.HttpResponseException;
import org.keycloak.representations.idm.authorization.AuthorizationResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthzClient authzClient;

    public TokenInfo login(String email, String pass) throws Exception {
        log.info("START login for user {}", email);
        try {
            AuthorizationResponse response = authzClient.authorization(email, pass)
                    .authorize();
            TokenInfo result = TokenInfo.builder()
                    .tokenType(response.getTokenType())
                    .token(response.getToken()).build();
            log.info("FINISH login for user {} successfully", email);
            return result;
        } catch (AuthorizationDeniedException | HttpResponseException ex) {
            log.debug("Exception when login {}", email, ex);
            log.info("FINISH login for user {} is bad", email);
            throw new Exception(); //BadAuthorizeException();
        } catch (Exception ex) {
            log.error("Some error occurred during login");
            throw new Exception(); //BadAuthorizeException();
        }
    }

    public Token getUserToken(String username, String password){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", SecurityConstants.PASSWORD);
        map.add(SecurityConstants.USERNAME, username);
        map.add(SecurityConstants.PASSWORD, password);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<Token> responseEntity = restTemplate.postForEntity("http://localhost:7432/realms/market-place/protocol/openid-connect/token",
                entity, Token.class);

        return responseEntity.getBody();
    }

    public Token getClientToken(String clientId, String secret){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", SecurityConstants.CLIENT_CREDENTIALS);
        map.add(SecurityConstants.CLIENT_ID, clientId);
        map.add(SecurityConstants.CLIENT_SECRET, secret);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);



        ResponseEntity<Token> responseEntity = restTemplate.postForEntity("http://localhost:7432/realms/market-place/protocol/openid-connect/token",
                entity, Token.class);

        return responseEntity.getBody();
    }

    public void createUser(String firstName, String lastName, String email, String username, String token){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject json = new JSONObject();
        json.put("firstName", firstName);
        json.put("lastName", lastName);
        json.put("email", email);
        json.put("username", username);

        headers.add("Authorization", "Bearer " + token);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(json.toMap(), headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(Api.CREATE_USER_KEYCLOAK,
                entity, String.class);
    }


}
