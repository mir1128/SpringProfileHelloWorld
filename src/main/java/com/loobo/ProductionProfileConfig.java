package com.loobo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class ProductionProfileConfig {
    @Bean
    public CDPlayer cdPlayer() {
        return new ProductionCDPlayer();
    }
}
