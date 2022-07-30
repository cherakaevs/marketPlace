package com.custom.marketPlace.constants;

import static com.custom.marketPlace.security.constants.SecurityConstants.MAIN_REALM;

public interface Api {
    String REGISTRATION = "/api/v1/registration";
    String LOGIN = "/api/v1/login";
    String CLIENT_SECRETS_PAGE = "/api/v1/admin/clients";
    String CREATE_USER_KEYCLOAK = String.format("/admin/realms/%s/users", MAIN_REALM);
    String TOKEN_ENDPOINT = String.format("/realms/%s/protocol/openid-connect/token", MAIN_REALM);

}
