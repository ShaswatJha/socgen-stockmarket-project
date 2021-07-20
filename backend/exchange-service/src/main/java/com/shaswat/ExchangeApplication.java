package com.shaswat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.shaswat.repository.ExchangeRepository;

@SpringBootApplication(scanBasePackages={
        "com.shaswat", "shaswat"})
@EnableMongoRepositories(basePackageClasses = ExchangeRepository.class)
public class ExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeApplication.class, args);
    }
}
