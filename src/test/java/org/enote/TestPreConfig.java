package org.enote;

import org.enote.config.ProfilesConfig;
import org.enote.config.DataSourceConfig;
import org.enote.config.PersistenceConfig;
import org.junit.BeforeClass;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {PersistenceConfig.class, DataSourceConfig.class})
public class TestPreConfig {

    @BeforeClass
    public static void setup() {
        System.setProperty("spring.profiles.active", ProfilesConfig.PROFILE_DEV);
    }
}
