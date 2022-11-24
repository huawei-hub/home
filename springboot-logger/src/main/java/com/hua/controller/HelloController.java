package com.hua.controller;

//import com.hua.scheduled.LogMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private LoggingSystem loggingSystem;
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/updateLoggingLevel")
    public void updateLoggingLevel2(String level,String name) {
        LogLevel logLevel = LogLevel.valueOf(level.toUpperCase());
        loggingSystem.setLogLevel(name, logLevel);
        log.info("changed {} logging level to:{}", name, logLevel);
    }


    @GetMapping("/logAop")
    public String logAop(String param) {
        return "success -> " + param;
    }
}
