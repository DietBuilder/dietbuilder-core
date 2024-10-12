package com.dietbuilder.boot;

import com.dietbuilder.core.services.InitializeDatabaseService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.dietbuilder")
@EnableJpaRepositories(basePackages = "com.dietbuilder")
@EntityScan(basePackages = "com.dietbuilder")
@AllArgsConstructor
public class DietBuilderApplication implements CommandLineRunner {

    private InitializeDatabaseService initializeDatabaseService;

    public static void main(String[] args) {
        SpringApplication.run(DietBuilderApplication.class, args);
    }

    @Override
    public void run(String... args) {
        initializeDatabaseService.dropDatabase();
        initializeDatabaseService.initializeComestibleProducts();
        initializeDatabaseService.initializeMeals();
    }
}
