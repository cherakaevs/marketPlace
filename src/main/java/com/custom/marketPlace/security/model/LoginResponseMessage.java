package com.custom.marketPlace.security.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/* TODO: Лучше и назвать так: TokenInfo или что-то наподобии. Немного путает LoginResponseMessage */
@Builder
@Data
@AllArgsConstructor
public class LoginResponseMessage   {
    @JsonProperty("token" /* TODO: В константы */)
    private String token;

    @JsonProperty("refreshToken" /* TODO: В константы */)
    private String refreshToken;

    @JsonProperty("tokenType" /* TODO: В константы */)
    private String tokenType;
}
