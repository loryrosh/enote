package org.enote.config;

import org.enote.AppConfig;
import org.enote.config.db.DataSourceConfig;
import org.enote.config.db.PersistenceConfig;
import org.junit.BeforeClass;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {PersistenceConfig.class, DataSourceConfig.class})
public class TestPreConfig {

    @BeforeClass
    public static void setup() {
        System.setProperty("spring.profiles.active", AppConfig.PROFILE_DEV);
    }
}
