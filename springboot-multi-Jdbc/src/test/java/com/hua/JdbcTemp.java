package com.hua;

import org.junit.Test;

import java.sql.*;

public class JdbcTemp {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/lk?characterEncoding=UTF-8";
    private String username = "root";
    private String password = "root";

    //测试连接
    @Test
    public void connectionTest(){
        try {
            //加载mysql驱动
            Class.forName(driver);
            //获取数据库连接
            Connection conn = DriverManager.getConnection(url,username,password);
            String sql = "select id,name,salary,managerId from employee";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            int columnCount = resultSet.getMetaData().getColumnCount();
            //获取所有列名
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println(metaData.getColumnName(i));
            }
            System.out.println("============");
            System.out.println("columnCount = " + columnCount);
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(resultSet.getObject(i) + "\t\t");
                }
                System.out.println();
            }


//            ParameterMetaData paramMetaData = ps.getParameterMetaData();
//            int columnCount = metaData.getColumnCount();
//            int columnType = metaData.getColumnType(3);
//            System.out.println("columnType = " + columnType);
//
//            int[] paramType = new int[columnCount+ 1];
//            for (int i = 1; i <= columnCount; i++) {
//                System.out.println(metaData.getColumnName(i) + " " +
//                        metaData.getColumnType(i) + " " +
//                        metaData.getColumnTypeName(i));
//                paramType[i] = 1;
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //测试Jdbc
    @Test
    public void testJdbc() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://39.106.139.198:3306/yunkeyo?characterEncoding=UTF-8";
            String username = "root";
            String password = "yunkeyo123456!";
            //加载mysql驱动
            Class.forName(driver);
            //获取数据库连接
            Connection conn = DriverManager.getConnection(url,username,password);
            String sql = "select depart_name from admin_dept_info";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String departName = rs.getString("depart_name");
                System.out.println("departName = " + departName);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
