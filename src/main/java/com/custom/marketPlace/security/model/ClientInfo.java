package com.custom.marketPlace.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ClientInfo {

    public final int index;
    public final String clientId;
    public final String secret;
    public final String appUrl;

}
