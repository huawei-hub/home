package com.hua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DynamicLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicLogApplication.class, args);
    }
}
