package org.enote;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource({"classpath:user_${spring.profiles.active}.properties"})
public class UserConfig {
    @Value("${activeUserEmail}")
    private String activeUserEmail;

    @Value("${activePassword}")
    private String activePassword;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public String getActiveUserEmail() {
        return activeUserEmail;
    }

    public String getActivePassword() {
        return activePassword;
    }
}
