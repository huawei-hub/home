package com.hua.调用shell;
import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.*;
import java.nio.charset.Charset;

public class RemoteShellExecutor {
    private Connection conn;
    private String ip;
    private String username;
    private String password;
    private static final int TIME_OUT = 1000 * 60;// 表示不超时
    private String charset = Charset.defaultCharset().toString();

    public RemoteShellExecutor(String ip, String username, String password) {
        this.ip = ip;
        this.username = username;
        this.password = password;
    }

    private boolean login() throws IOException {
        conn = new Connection(ip);
        conn.connect();
        return conn.authenticateWithPassword(username, password);
    }

    public String exec(String shell) throws Exception {
        Session session = null;
        InputStream stdOut = null;
        InputStream stdErr = null;
        PrintWriter pw;
        String outStr, outErr;
        try{
            if (login()) {
                //跨服务器远程调用shell脚本需要配置
                session = conn.openSession();
                session.requestPTY("bash");
                session.startShell();
                pw = new PrintWriter(session.getStdin());
                pw.println(shell);
                pw.println("exit");
                pw.close();
                stdOut = new StreamGobbler(session.getStdout());
                outStr = processStream(stdOut, charset);
                stdErr = new StreamGobbler(session.getStderr());
                outErr = processStream(stdErr, charset);
                session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
                System.out.println("outStr= " + outStr);
                System.out.println("outErr= " + outErr);
            } else {
                throw new Exception("登录远程机器失败" + ip); // 自定义异常类 实现略
            }
        }finally {
            if (stdOut != null) {
                stdOut.close();
            }
            if (stdErr != null) {
                stdErr.close();
            }
            if (session != null) {
                session.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        if (outStr.contains("ERROR")){
            return "存储过程运行失败"+outStr;
        }else if (outErr.length()>0){
            return "shell调用失败";
        }else {
            return "";
        }

    }

    private String processStream(InputStream in, String charset) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader brs = new BufferedReader(new InputStreamReader(in, charset));
        for (String line = brs.readLine(); line != null; line = brs.readLine()) {
            sb.append(line).append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
