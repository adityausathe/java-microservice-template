package com.adus.dbmigration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class DatabaseMigrationService {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseMigrationService.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> log.info("performing migration... //TODO: add actual migration-code");
    }
}
