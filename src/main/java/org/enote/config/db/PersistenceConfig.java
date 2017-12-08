package org.enote.config.db;

import org.enote.config.db.DBConfig;
import org.enote.config.db.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.support.MergingPersistenceUnitManager;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@Import({DataSourceConfig.class})
@EnableJpaRepositories(basePackages = {"org.enote.repos"})
public class PersistenceConfig {

    @Autowired
    DataSourceConfig dataSourceConfig;

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitManager(persistenceUnitManager());
        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(dataSourceConfig.hibernateProperties());
        factoryBean.afterPropertiesSet();
        factoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    public PersistenceUnitManager persistenceUnitManager(){
        MergingPersistenceUnitManager persistenceUnitManager = new MergingPersistenceUnitManager();
        persistenceUnitManager.setPackagesToScan("org.enote.domain");
        persistenceUnitManager.setDefaultDataSource(dataSourceConfig.dataSource());
        return persistenceUnitManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
