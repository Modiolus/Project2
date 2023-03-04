package com.zaurtregulov.spring.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.zaurtregulov.spring.rest")

public class MyConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
