package com.hua.demo;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateTest {
    //
    @Test
    public void test1(){
        System.out.println(LocalDateTime.now());
    }

    //2
    @Test
    public void test2(){
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(instance.getTime());
        System.out.println("format = " + format);
        instance.add(Calendar.MINUTE, -1);
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(instance.getTime());
        System.out.println("format = " + format);
    }

    //8
    @Test
    public void test8() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        Date date1 = sdf.parse("2022-11-07 00");
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date1);
        System.out.println(sdf.format(instance.getTime()));
        if (date.getHours() == 9) {
            instance.add(Calendar.HOUR_OF_DAY, -9);
        } else {
            instance.add(Calendar.HOUR_OF_DAY, -1);
        }
        System.out.println(sdf.format(instance.getTime()));
    }

    //3
    @Test
    public void test3(){
        List list = new ArrayList();
        System.out.println(list.isEmpty());
    }

    //4
    @Test
    public void test4(){
        Map map = new HashMap();
        List list = new ArrayList();
        System.out.println(CollectionUtils.isEmpty(map));
        System.out.println(CollectionUtils.isEmpty(list));
        System.out.println(list.isEmpty());
    }

    //5
    @Test
    public void test5(){
//        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String format = now.format(dtf);
        System.out.println(format);
        LocalDateTime now1 = now.minusMinutes(20);
        format = now1.format(dtf);
        System.out.println(format);
    }

    //6
    @Test
    public void test6(){
        NumberFormat nf = NumberFormat.getPercentInstance();
        double a = 1.255532;
        nf.setMinimumFractionDigits(2);

        System.out.println(nf.format(a));
    }
    //7
    @Test
    public void test7(){
        System.out.println(new Date().toLocaleString());
        System.out.println(10 & 0xFF);
        System.out.println((10 >> 1) & 0xFF);
    }

    //8
    @Test
    public void test9(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String now = "2022-11-28_16:20:00";
            Date parse = sdf.parse(now);

            System.out.println(parse.getTime() > new Date().getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //10
    @Test
    public void test10(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String now = "20200131";
            Date date = sdf.parse(now);
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            instance.add(Calendar.DAY_OF_YEAR, 5);
            String str = sdf.format(instance.getTime()).substring(4);
            System.out.println("str -> " + str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test11() {
        int[] arr = {3, 9, -1, 10, 20};
        // 冒泡排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // 输出排序后的数组
        System.out.println(Arrays.toString(arr));
    }
}
