package org.enote.config.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:user.properties"})
public class UserConfig {
    @Value("${activeUser}")
    private String activeUser;

    @Value("${activePassword}")
    private String activePassword;


}
