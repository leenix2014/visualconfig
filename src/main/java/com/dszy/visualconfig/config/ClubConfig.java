package com.dszy.visualconfig.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        entityManagerFactoryRef="clubEntityManagerFactory",
        transactionManagerRef="clubTransactionManager",
        basePackages= { "com.dszy.visualconfig.repo.club" }) //设置Repository所在位置
public class ClubConfig {

    @Autowired
    @Qualifier("clubDataSource")
    private DataSource clubDataSource;

    //@Primary
    @Bean(name = "clubEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return clubEntityManagerFactory(builder).getObject().createEntityManager();
    }

    //@Primary
    @Bean(name = "clubEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean clubEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(clubDataSource)
                .packages("com.dszy.visualconfig.entity") //设置实体类所在位置
                .persistenceUnit("clubPersistenceUnit")
                .build();
    }

    //@Primary
    @Bean(name = "clubTransactionManager")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(clubEntityManagerFactory(builder).getObject());
    }
}
