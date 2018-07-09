package com.dszy.visualconfig.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="activityEntityManagerFactory",
        transactionManagerRef="activityTransactionManager",
        basePackages= { "com.dszy.visualconfig.repo.activity" }) //设置Repository所在位置
public class ActivityConfig {

    @Autowired
    @Qualifier("activityDataSource")
    private DataSource activityDataSource;

    @Primary
    @Bean(name = "activityEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return activityEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "activityEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean activityEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(activityDataSource)
                .packages("com.dszy.visualconfig.entity") //设置实体类所在位置
                .persistenceUnit("activityPersistenceUnit")
                .build();
    }

    @Primary
    @Bean(name = "activityTransactionManager")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(activityEntityManagerFactory(builder).getObject());
    }
}
