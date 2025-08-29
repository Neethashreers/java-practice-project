package com.curd.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.usercrudapi", "com.curd.api"})
@EnableJpaRepositories(basePackages = "com.example.usercrudapi.repository")
@EntityScan(basePackages = "com.example.usercrudapi.model")
public class UserCurdApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCurdApplication.class, args);
    }
}
