package org.enote;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.env.Environment;

public class Utils {

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
