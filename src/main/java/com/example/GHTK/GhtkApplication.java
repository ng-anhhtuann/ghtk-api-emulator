package com.example.GHTK;

import com.example.GHTK.Ultilities.JWT;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
//@SpringBootApplication
public class GhtkApplication {

    public static void main(String[] args) {
        SpringApplication.run(GhtkApplication.class, args);
    }

}
