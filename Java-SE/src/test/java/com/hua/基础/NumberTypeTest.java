package com.hua.基础;

import org.junit.Test;

import java.text.NumberFormat;

//数据处理
public class NumberTypeTest {

    //将小数四舍五入转化为百分比
    @Test
    public void test1(){
        NumberFormat nf = NumberFormat.getPercentInstance();
        double a = 1.255562;
        nf.setMinimumFractionDigits(2);
        System.out.println(nf.format(a));
    }
}
