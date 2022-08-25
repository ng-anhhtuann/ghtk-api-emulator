package com.example.GHTK;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableWebMvc
@OpenAPIDefinition(info = @Info(title = "API connected to MySQL", version = "1.0", description = "Senior Title"))
public class GhtkApplication {
    public static void main(String[] args) {
        SpringApplication.run(GhtkApplication.class, args);
    }

}
