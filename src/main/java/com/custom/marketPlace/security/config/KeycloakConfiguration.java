package com.custom.marketPlace.security.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.authorization.client.AuthzClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {

    @Bean
    public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    public AuthzClient keycloakAuthzClient(KeycloakSpringBootProperties props) {
        org.keycloak.authorization.client.Configuration config = new org.keycloak.authorization.client.Configuration(
                props.getAuthServerUrl(), props.getRealm(),
                props.getResource(), props.getCredentials(), null);
        config.setBearerOnly(false);
        return AuthzClient.create(config);
    }

    @Bean
    public Keycloak keycloak(KeycloakSpringBootProperties props) {
        return KeycloakBuilder.builder()
                .serverUrl(props.getAuthServerUrl())
                .realm(props.getRealm())
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId(props.getResource())
                .clientSecret((String) props.getCredentials().get("secret"))
                .build();
    }
}