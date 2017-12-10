package org.enote;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource({"classpath:user.properties"})
public class UserConfig {
    @Value("${activeUser}")
    private String activeUser;

    @Value("${activePassword}")
    private String activePassword;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public String getActiveUser() {
        return activeUser;
    }

    public String getActivePassword() {
        return activePassword;
    }
}
