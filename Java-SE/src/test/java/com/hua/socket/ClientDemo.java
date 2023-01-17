package com.hua.socket;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    private static final String ip = "127.0.0.1";
    private static final int port = 6666;

    public static void main(String[] args) {
        System.out.println("客户端启动！！！");
        while (true) {
            Socket socket = null;
            try {
                socket = new Socket(ip, port);

                //读服务器发送数据
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintStream out = new PrintStream(socket.getOutputStream());
                System.out.print("请输入数据：\t");
                String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
                out.println(str);

                //接受发送回来的数据
                String serverBack = input.readLine();
                System.out.println("客户端返回的数据：" + serverBack);
                //如果返回
                if ("OK".equals(serverBack)) {
                    System.out.println("客户端关闭");
                    Thread.sleep(500);
                    break;
                }
                input.close();
                out.close();
            } catch (Exception e) {
                System.out.println("客户端 run 异常：" + e.getMessage());
            }finally {
                if (null != socket) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        System.out.println("客户端运行异常：" + e.getMessage());
                    }
                }
            }
        }
    }
}
