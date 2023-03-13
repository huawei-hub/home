package com.hua.基础;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ShellDemo {
    //调用shell脚本
    @Test
    public void testShell() {
        sendShell();
    }

    private void sendShell() {
        String line;
        String[] cmd = {"./", "/Users/fuhuawei/Desktop/test.sh", ""};
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            while ((line = reader.readLine()) != null) {
                System.out.println("line = " + line);
            }
            reader.close();
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //
    @Test
    public void test() {
        System.out.println("".equals("1"));
    }

    //执行脚本
    @Test
    public void execShell() {
        try {
            ProcessBuilder pb = new ProcessBuilder().command("/Users/fuhuawei/Desktop/test.sh","八嘎呀路");
            pb.redirectErrorStream(true);
            Process p = pb.start();
            p.waitFor();
            InputStream inputStream = p.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            String line;

            while ((line = br.readLine()) != null) {
//                outPutResult.append(line).append("\n");
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
