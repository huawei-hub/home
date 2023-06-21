package com.hua.调用shell;

import org.junit.Test;

public class DemoShell {
    //测试shell
    @Test
    public void testShell(){
        try {
            RemoteShellExecutor se = new RemoteShellExecutor("39.106.139.198","root","yunkeyo123456!");

            String exec = se.exec("sh /tmp/a.sh");
            System.out.println(exec);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
