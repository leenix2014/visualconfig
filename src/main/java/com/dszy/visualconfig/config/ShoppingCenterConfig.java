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
        entityManagerFactoryRef="shoppingcenterEntityManagerFactory",
        transactionManagerRef="shoppingcenterTransactionManager",
        basePackages= { "com.dszy.visualconfig.repo.shoppingcenter" }) //设置Repository所在位置
public class ShoppingCenterConfig {

    @Autowired
    @Qualifier("shoppingcenterDataSource")
    private DataSource shoppingcenterDataSource;

    //@Primary
    @Bean(name = "shoppingcenterEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return shoppingcenterEntityManagerFactory(builder).getObject().createEntityManager();
    }

    //@Primary
    @Bean(name = "shoppingcenterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean shoppingcenterEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(shoppingcenterDataSource)
                .packages("com.dszy.visualconfig.entity") //设置实体类所在位置
                .persistenceUnit("shoppingcenterPersistenceUnit")
                .build();
    }

    //@Primary
    @Bean(name = "shoppingcenterTransactionManager")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(shoppingcenterEntityManagerFactory(builder).getObject());
    }
}
