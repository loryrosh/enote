package org.enote.config;

import org.enote.config.db.DataSourceConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Properties;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataSourceConfig.class})
public class DataSourceConfigTest {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfigTest.class);

    @Autowired
    DataSourceConfig dataSourceConfig;

    @Autowired
    Properties hibernateProperties;

    @Autowired
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer;

    @Autowired
    DataSource dataSource;

    @Test
    public void testBeansCreated() {
        assertNotNull(dataSourceConfig);
        assertNotNull(propertySourcesPlaceholderConfigurer);
        assertNotNull(hibernateProperties);
        assertNotNull(dataSource);

        logger.info("hibernate.show_sql -> " +  hibernateProperties.get("hibernate.show_sql"));
    }
}
