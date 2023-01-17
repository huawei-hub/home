package com.hua.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    private static final int port = 6666;

    public static void main(String[] args) {
        System.out.println("server...");
        ServerDemo server = new ServerDemo();
        server.init();
    }

    public void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                new HandlerThread(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class HandlerThread implements Runnable {
        private Socket socket;
        public HandlerThread(Socket client) {
            socket = client;
            new Thread(this).start();
        }
        @Override
        public void run() {
            try {
                //接受客户端发送的流
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String clientStr = input.readLine();
                //处理客户端发送来的消息
                System.out.print("客户端发送的消息：" + clientStr);

                //给客户端恢复消息
                PrintStream out = new PrintStream(socket.getOutputStream());
                System.out.print("请输入回复内容：\t");

                String writeBack = new BufferedReader(new InputStreamReader(System.in)).readLine();
                out.print(writeBack);

                out.close();
                input.close();
            } catch (IOException e) {
                System.out.println("服务 run 异常："+ e.getMessage());
            }finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        socket = null;
                        System.out.println("服务端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }
    }
}
