package com.custom.marketPlace.security.services;

import com.custom.marketPlace.constants.Api;
import com.custom.marketPlace.security.model.KeycloakUser;
import com.custom.marketPlace.security.model.OAuth2Token;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.OAuth2Constants;
import org.keycloak.authorization.client.AuthorizationDeniedException;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.util.HttpResponseException;
import org.keycloak.representations.idm.authorization.AuthorizationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static com.custom.marketPlace.constants.PropertiesPlaceholders.KEYCLOAK_AUTH_URL;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthzClient authzClient;

    @Value(KEYCLOAK_AUTH_URL)
    private String KEYCLOAK_URL;

    public OAuth2Token login(String email, String pass) throws Exception {
        log.info("START login for user {}", email);
        try {
            AuthorizationResponse response = authzClient.authorization(email, pass)
                    .authorize();
            OAuth2Token result = OAuth2Token.builder()
                    .tokenType(response.getTokenType())
                    .accessToken(response.getToken()).build();
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

    public OAuth2Token getUserToken(String username, String password){

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add(OAuth2Constants.GRANT_TYPE, OAuth2Constants.PASSWORD);
        body.add(OAuth2Constants.USERNAME, username);
        body.add(OAuth2Constants.PASSWORD, password);

        return getToken(body);
    }

    public OAuth2Token getClientToken(String clientId, String secret){

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add(OAuth2Constants.GRANT_TYPE, OAuth2Constants.CLIENT_CREDENTIALS);
        body.add(OAuth2Constants.CLIENT_ID, clientId);
        body.add(OAuth2Constants.CLIENT_SECRET, secret);

        return getToken(body);
    }

    private OAuth2Token getToken(MultiValueMap<String, String> body) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        String tokenEndpoint = KEYCLOAK_URL + Api.TOKEN_ENDPOINT;

        ResponseEntity<OAuth2Token> responseEntity = restTemplate.postForEntity(tokenEndpoint, entity, OAuth2Token.class);
        return responseEntity.getBody();
    }

    public void createUser(String firstName, String lastName, String email, String username, String token){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        KeycloakUser user = KeycloakUser.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .username(username)
                .build();

        headers.setBearerAuth(token);

        HttpEntity<KeycloakUser> entity = new HttpEntity<>(user, headers);

        String createUserUrl = KEYCLOAK_URL + Api.CREATE_USER_KEYCLOAK;
        restTemplate.postForEntity(createUserUrl, entity, String.class);
    }


}
