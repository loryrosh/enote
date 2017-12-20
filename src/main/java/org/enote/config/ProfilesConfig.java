package org.enote.config;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class ProfilesConfig {

    public static final String PROFILE_DEV = "dev";
    public static final String PROFILE_PROD = "prod";

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
