package com.custom.marketPlace.constants;

public interface DatabaseConstants {
    String POSTGRES_DIALECT = "org.hibernate.dialect.PostgreSQL94Dialect";

    /* Placeholders */
    String DATABASE_URL_PLACEHOLDER = "${marketplace.database.url}";
    String DATABASE_USERNAME_PLACEHOLDER = "${marketplace.database.username}";
    String DATABASE_PASSWORD_PLACEHOLDER = "${marketplace.database.password}";
}