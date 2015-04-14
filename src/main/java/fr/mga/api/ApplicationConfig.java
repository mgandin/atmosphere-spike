package fr.mga.api;

import org.atmosphere.cpr.AtmosphereServlet;
import org.atmosphere.cpr.ContainerInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Collections;

@Configuration
public class ApplicationConfig {


    @Bean
    public Payment payment() {
        return new Payment();
    }
}
