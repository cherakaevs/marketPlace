package com.custom.marketPlace.security.model;


import com.custom.marketPlace.security.constants.SecurityConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TokenInfo {
    @JsonProperty(SecurityConstants.TOKEN)
    private String token;

    @JsonProperty(SecurityConstants.REFRESH_TOKEN)
    private String refreshToken;

    @JsonProperty(SecurityConstants.TOKEN_TYPE)
    private String tokenType;
}
