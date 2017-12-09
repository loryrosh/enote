package org.enote.config;

import org.junit.BeforeClass;

public class TestPreConfig {

    private static final String ACTIVE_PROFILE = "prod";

    @BeforeClass
    public static void setup() {
        System.setProperty("spring.profiles.active", ACTIVE_PROFILE);
    }
}
