package org.enote;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = {"org.enote.config.db", "org.enote.services.impl"})
public class AppConfig {

    public static final String PROFILE_DEV = "dev";
    public static final String PROFILE_PROD = "prod";

    public static final String CURRENT_USER_PROFILE = "John";

    /**
     * Gets active Spring profile
     *
     * @param environment Spring environment
     * @return current profile type
     */
    public static String getProfile(Environment environment) {
        String[] profiles = environment.getActiveProfiles();
        if (ArrayUtils.contains(profiles, PROFILE_PROD)) {
            return PROFILE_PROD;
        }
        return PROFILE_DEV;
    }
}
