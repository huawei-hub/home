//package com.hua.listen;
//
//import com.hua.scheduled.LogMonitor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.annotation.Scheduled;
//
//public class PrintLog {
//
//    private static final Logger log = LoggerFactory.getLogger(PrintLog.class);
//
//    @Scheduled(cron = "0/5 * * * * ?")
//    public void sendDebug() {
//        log.debug("print log debug !");
//    }
//
//    @Scheduled(cron = "1/5 * * * * ?")
//    public void sendInfo() {
//        log.info("print log info !");
//    }
//
//    @Scheduled(cron = "2/5 * * * * ?")
//    public void sendError() {
//        log.error("print log error !");
//    }
//}
