package com.wj.tools;

import java.sql.*;

public class DBUtil {
    public static Connection conn;
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easybuy?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8","root","root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    public static ResultSet select(String sql, Object... object) {
        conn = getConnection();
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < object.length; i++) {
                ps.setObject(i+1,object[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }
    public static int addDeleteUpdate(String sql,Object... object){
        conn = getConnection();
        int num = 0;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            for (int i = 0; i < object.length; i++) {
                ps.setObject(i+1,object[i]);
            }
            num = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        shutDB();
        return num;
    }
    public static void shutDB(){
        try {
                if (rs!=null) {
                    rs.close();
                }
                if (ps!=null) {
                    ps.close();
                }
                if (conn!=null) {
                    conn.close();
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
