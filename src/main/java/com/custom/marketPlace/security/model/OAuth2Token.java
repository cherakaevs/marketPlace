package com.custom.marketPlace.security.model;

import com.custom.marketPlace.security.constants.SecurityConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.Hibernate;
import org.keycloak.OAuth2Constants;

import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuth2Token {
    @JsonProperty(OAuth2Constants.ACCESS_TOKEN)
    private String accessToken;

    @JsonProperty(SecurityConstants.EXPIRES_IN)
    private int expiresIn;

    @JsonProperty(SecurityConstants.REFRESH_EXPIRES_IN)
    private int refreshExpiresIn;

    @JsonProperty(SecurityConstants.TOKEN_TYPE)
    private String tokenType;

    @JsonProperty(SecurityConstants.NOT_BEFORE_POLICY)
    private int notBeforePolicy;

    @JsonProperty(OAuth2Constants.SCOPE)
    private String scope;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OAuth2Token token = (OAuth2Token) o;
        return accessToken != null && Objects.equals(accessToken, token.accessToken);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
