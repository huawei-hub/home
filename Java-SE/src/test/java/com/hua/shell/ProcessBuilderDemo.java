package com.hua.shell;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

//测试执行本地脚本
public class ProcessBuilderDemo {
    //删除方法
    @Test
    public void test(){
        try {
            String[] arr = new String[]{"rm", "-rf", "/Users/fuhuawei/Desktop/截屏*"};
            ProcessBuilder pb = new ProcessBuilder(arr);
            pb.redirectErrorStream(true);

            Process p = pb.start();
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));
            String line;
            if ((line = reader.readLine())!=null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
