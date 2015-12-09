package com.loobo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
public class DevelopmentProfileConfig {
    @Bean
    public CDPlayer cdPlayer() {
        return new DevelopCDPlayer();
    }
}
