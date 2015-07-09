package fr.mga.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {


    @Bean
    public Payment payment() {
        return new Payment();
    }
}
