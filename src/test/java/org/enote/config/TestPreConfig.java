package org.enote.config;

import org.enote.Utils;
import org.enote.config.db.DataSourceConfig;
import org.enote.config.db.PersistenceConfig;
import org.junit.BeforeClass;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {PersistenceConfig.class, DataSourceConfig.class})
public class TestPreConfig {

    @BeforeClass
    public static void setup() {
        System.setProperty("spring.profiles.active", Utils.PROFILE_DEV);
    }
}
