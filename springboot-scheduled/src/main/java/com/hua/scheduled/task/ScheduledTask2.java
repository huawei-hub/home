package com.hua.scheduled.task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class ScheduledTask2 {
    /*
        @Scheduled(fixedRate=2000)：上一次开始执行时间点后2秒再次执行；
        @Scheduled(fixedDelay=2000)：上一次执行完毕时间点后2秒再次执行；
        @Scheduled(initialDelay=1000, fixedDelay=2000)：第一次延迟1秒执行，然后在上一次执行完毕时间点后2秒再次执行；
    */
 
    private Logger logger = LoggerFactory.getLogger(ScheduledTask2.class);
 
    private int fixedDelayCount = 1;
    private int fixedRateCount = 1;
    private int initialDelayCount = 1;
    private static int cronCount = 1;

    //fixedDelay = 5000表示当前方法执行完毕5000ms后，Spring scheduling会再次调用该方法
    @Scheduled(fixedDelay = 5000)
    public void testFixDelay() {
        logger.info("===fixedDelay: 第{}次执行方法", fixedDelayCount++);
    }

    //fixedRate = 5000表示当前方法开始执行5000ms后，Spring scheduling会再次调用该方法
    @Scheduled(fixedRate = 5000)
    public void testFixedRate() {
        logger.info("===fixedRate: 第{}次执行方法", fixedRateCount++);
    }

    //initialDelay = 1000表示延迟1000ms执行第一次任务
    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void testInitialDelay() {
        logger.info("===initialDelay: 第{}次执行方法", initialDelayCount++);
    }

    //cron接受cron表达式，根据cron表达式确定定时规则
    @Scheduled(cron = "0 0/1 * * * ?")
    public void testCron() {
        logger.info("===initialDelay: 第{}次执行方法", cronCount++);
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void testCron1() {
        logger.info("===initialDelay1: 第{}次执行方法", 1);
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void testCron2() {
        logger.info("===initialDelay2: 第{}次执行方法", 1);
    }

    @Scheduled(cron = "0 0/1 * * * ?")
    public void testCron3() {
        logger.info("===initialDelay3: 第{}次执行方法", 1);
    }
}