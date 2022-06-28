package com.custom.marketPlace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import java.util.Properties;

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

    @Value("${marketplace.jpa.policy}")
    private String jpaPolicy;

    @Value("${marketplace.jpa.enablelog}")
    private String jpaLogs;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(databaseUrl);
        dataSourceBuilder.username(databaseUsername);
        dataSourceBuilder.password(databasePassword);
        return dataSourceBuilder.build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPackagesToScan(new String[] { "com.custom.marketPlace.model" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", jpaPolicy);
        jpaProperties.put("hibernate.show_sql",jpaLogs);
        em.setJpaProperties(jpaProperties);

        return em;
    }
}