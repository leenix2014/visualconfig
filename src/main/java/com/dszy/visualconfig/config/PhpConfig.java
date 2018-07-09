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
        entityManagerFactoryRef="phpEntityManagerFactory",
        transactionManagerRef="phpTransactionManager",
        basePackages= { "com.dszy.visualconfig.repo.php" }) //设置Repository所在位置
public class PhpConfig {

    @Autowired
    @Qualifier("phpDataSource")
    private DataSource phpDataSource;

    //@Primary
    @Bean(name = "phpEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return phpEntityManagerFactory(builder).getObject().createEntityManager();
    }

    //@Primary
    @Bean(name = "phpEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean phpEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(phpDataSource)
                .packages("com.dszy.visualconfig.entity") //设置实体类所在位置
                .persistenceUnit("phpPersistenceUnit")
                .build();
    }

    //@Primary
    @Bean(name = "phpTransactionManager")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(phpEntityManagerFactory(builder).getObject());
    }
}
