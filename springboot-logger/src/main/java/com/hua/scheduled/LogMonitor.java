//package com.hua.scheduled;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//public class LogMonitor {
//    //DEBUG < INFO < WARN < ERROR
//    private static final Logger log = LoggerFactory.getLogger(LogMonitor.class);
//
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void sendDebug() {
//        log.debug("scheduled log debug !");
//    }
//
//    @Scheduled(cron = "1/5 * * * * ?")
//    public void sendInfo() {
//        log.info("scheduled log info !");
//    }
//
//    @Scheduled(cron = "2/5 * * * * ?")
//    public void sendError() {
//        log.error("scheduled log error !");
//    }
//}
