package org.enote;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"org.enote.controllers", "org.enote.services.impl"})
public class Config {

    @Bean
    public ViewResolver getViewResolver() {
        return new InternalResourceViewResolver("/WEB-INF/", ".jsp");
    }
}
