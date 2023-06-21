package com.hua.基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DemoScanner {
    public static void main(String[] args) throws IOException {
        System.out.print("请输入数据：");
        InputStream in = System.in;
        String s = new BufferedReader(new InputStreamReader(in)).readLine();
        System.out.println("重新打印一遍:" + s);
    }
}
