package org.enote.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"org.enote.config.db", "org.enote.services", "org.enote.repos"})
public class AppConfig {
}
