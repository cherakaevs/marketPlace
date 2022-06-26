package com.custom.marketPlace.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import static com.custom.marketPlace.constants.DatabaseConstants.*;

@Configuration
@ComponentScan(basePackages = "java")
@EnableTransactionManagement
public class DataSourceConfig {

    @Value(DATABASE_URL_PLACEHOLDER)
    private String databaseUrl;

    @Value(DATABASE_USERNAME_PLACEHOLDER)
    private String databaseUsername;

    @Value(DATABASE_PASSWORD_PLACEHOLDER)
    private String databasePassword;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(databaseUrl);
        dataSourceBuilder.username(databaseUsername);
        dataSourceBuilder.password(databasePassword);
        return dataSourceBuilder.build();
    }
}