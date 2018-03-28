package com.game.fizzbuzz.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ComponentScan(basePackages = {
        "com.game.fizzbuzz.endpoint.impl",
        "com.game.fizzbuzz.service.impl"
})
public class SpringConfig { 
}
