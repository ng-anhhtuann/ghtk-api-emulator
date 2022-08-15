package com.example.GHTK;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@OpenAPIDefinition(info = @Info(title = "API connected to MySQL", version = "1.0", description = "Senior Title"))
public class GhtkApplication {

    public static void main(String[] args) {
        SpringApplication.run(GhtkApplication.class, args);
    }

}
