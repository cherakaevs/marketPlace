package com.custom.marketPlace.security.constants;

public interface SecurityConstants {

    // TODO: бОльшая часть констант местных есть в OAuth2Constants (либный класс). Давай здесь, наверное, нашу конфигурацию
    //  описывать: наш реалм, наших клиентов (есть класс SecurityClientManagers, можно оттуда перенести константы сюда). То есть то, что
    //  является конкретно нашим
    /* Grant Types */
    String GRANT_TYPE = "grant_type";
    String CLIENT_CREDENTIALS = "client_credentials";
    String PASSWORD = "password";

    /* Client Credentials*/
    String CLIENT_ID = "client_id";
    String CLIENT_SECRET = "client_secret";

    /* Password */
    String USERNAME = "username";

    /* TokenInfo */
    String TOKEN = "token";
    String REFRESH_TOKEN = "refreshToken";
    String TOKEN_TYPE = "tokenType";
}
