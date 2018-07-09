package com.dszy.visualconfig.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "activityDataSource")
    @Qualifier("activityDataSource")
    @ConfigurationProperties(prefix="spring.datasource.activity")
    @Primary
    public DataSource activityDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "shoppingcenterDataSource")
    @Qualifier("shoppingcenterDataSource")
    @ConfigurationProperties(prefix="spring.datasource.shoppingcenter")
    public DataSource shoppingcenterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "clubDataSource")
    @Qualifier("clubDataSource")
    @ConfigurationProperties(prefix="spring.datasource.club")
    public DataSource clubDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "phpDataSource")
    @Qualifier("phpDataSource")
    @ConfigurationProperties(prefix="spring.datasource.php")
    public DataSource phpDataSource() {
        return DataSourceBuilder.create().build();
    }
}
