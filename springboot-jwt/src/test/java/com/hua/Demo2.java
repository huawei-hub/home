package com.hua;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Demo2 {

    //1
    @Test
    public void test1(){
        String crontab = "0 0 0/1 * * ? ";
        CronSequenceGenerator cronGenerator = new CronSequenceGenerator(crontab);
        //下次预计的执行时间
        Date next = cronGenerator.next(new Date());
        //下下次预计的执行时间
        Date next2 = cronGenerator.next(next);
        //获取执行间隔
        long betweenS = next2.getTime() - next.getTime();
        System.out.println("betweenS = " + betweenS);
    }

}
