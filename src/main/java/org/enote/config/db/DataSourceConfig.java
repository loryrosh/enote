package org.enote.config.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource({"classpath:db.properties"})
public class DataSourceConfig implements DataConfig {

    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProp = new Properties();

        //hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        //hibernateProp.put("hibernate.hbm2ddl.auto", "update");

        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        hibernateProp.put("hibernate.show_sql", true);

        return hibernateProp;
    }

    @Override
    public DataSource dataSource() {
        return null;
    }
}
