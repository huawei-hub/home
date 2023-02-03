package com.hua;

import org.junit.Test;

import java.sql.*;

public class JdbcTemp {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/fk?characterEncoding=UTF-8";
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
            String sql = "select id,name,gender,phone from person";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            PreparedStatement ps = conn.prepareStatement(sql);

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

}
