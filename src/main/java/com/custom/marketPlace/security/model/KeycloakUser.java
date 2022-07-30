package com.custom.marketPlace.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class KeycloakUser {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
}
