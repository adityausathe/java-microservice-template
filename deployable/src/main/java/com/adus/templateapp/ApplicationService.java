package com.adus.templateapp;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

@Import(ApplicationConfig.class)
public class ApplicationService {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationService.class, args);
    }

}
