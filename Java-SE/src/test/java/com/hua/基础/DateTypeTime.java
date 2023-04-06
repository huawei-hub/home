package com.hua.基础;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

//时间的获取、加减、格式变化
public class DateTypeTime {

    //获取当前时间，格式：2023-02-03T10:42:02.016
    @Test
    public void getNowTime(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

    //LocalDateTime时间加减法
    @Test
    public void localDateTimeSub(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String format = now.format(dtf);
        System.out.println(format);
        LocalDateTime now1 = now.minusMinutes(20);
        format = now1.format(dtf);
        System.out.println(format);
    }

    //Date时间加减法
    @Test
    public void dateSub(){
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        String format = new SimpleDateFormat("HH:mm").format(instance.getTime());
        System.out.println("format = " + format);
        instance.add(Calendar.HOUR, -14);
        format = new SimpleDateFormat("HH:mm").format(instance.getTime());
        System.out.println("format = " + format);
    }

    //字符串转化为时间，且时间可以比较大小
    @Test
    public void parse(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String now = "2023-11-28_16:20:00";
            Date parse = sdf.parse(now);
            System.out.println(parse.getTime() > new Date().getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
