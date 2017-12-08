package org.enote.config.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource({"classpath:db.properties"})
public class DataSourceConfig implements DBConfig {

    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${url}")
    private String url;

    @Value("${db_user}")
    private String db_user;

    @Value("${db_password}")
    private String db_password;

    @Value("classpath:sql/db.sql")
    private Resource dbSQLSchema;

    @Value("classpath:sql/test_data_db.sql")
    private Resource dbSQLTestData;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProp = new Properties();

        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProp.put("hibernate.hbm2ddl.auto", "update");
        hibernateProp.put("hibernate.show_sql", true);
        hibernateProp.put("hibernate.format_sql", true);

        return hibernateProp;
    }

    @Override
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driverClassName);
        ds.setUrl(url);
        ds.setUsername(db_user);
        ds.setPassword(db_password);

        // process DB schema & initial test DB data
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(dbSQLSchema);
        populator.addScript(dbSQLTestData);
        DatabasePopulatorUtils.execute(populator, ds);

        return ds;
    }
}
