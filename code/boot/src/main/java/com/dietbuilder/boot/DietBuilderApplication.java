package com.dietbuilder.boot;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.dietbuilder")
@EnableJpaRepositories(basePackages = "com.dietbuilder")
@EntityScan(basePackages = "com.dietbuilder")
@AllArgsConstructor
public class DietBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DietBuilderApplication.class, args);
    }
}
