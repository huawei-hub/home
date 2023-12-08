package com.hua.基础;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
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
    public void getNowTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }

    //LocalDateTime时间加减法
    @Test
    public void localDateTimeSub() {
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
    public void dateSub() {
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
    public void parse() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String now = "2023-11-28_16:20:00";
            Date parse = sdf.parse(now);
            System.out.println(parse.getTime() > new Date().getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //1
    @Test
    public void test1() {
        DateTime startDate = DateUtil.offset(new Date(), DateField.HOUR_OF_DAY, -2);
        String startStr = DateUtil.format(startDate, "yyyyMMddHH") + "0000";
        DateTime endDate = DateUtil.offsetHour(startDate, -1);
        String endStr = DateUtil.format(endDate, "yyyyMMddHH") + "0000";
        System.out.println(startStr);
        System.out.println(endStr);
    }

    //2
    @Test
    public void test2(){
        String dateString = "20211001123000";
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            java.util.Date parsedDate = dateFormat.parse(dateString);
            Timestamp timestamp = new Timestamp(parsedDate.getTime());
            System.out.println(timestamp); // 输出: 2021-10-01 12:30:00.0
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
