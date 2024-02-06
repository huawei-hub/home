package com.hua;

import com.hua.demo.config.ConfigPropertiesValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoMain {
    public static void main(String[] args) {
        SpringApplication.run(DemoMain.class, args);
    }


    @Bean
    public ConfigPropertiesValidator configurationPropertiesValidator(){
        return new ConfigPropertiesValidator();
    }

}
