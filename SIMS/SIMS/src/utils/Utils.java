package utils;

import java.sql.*;

/**
 * Created by lanqiao on 2017/5/24.
 */
public class Utils {
    private static String url="jdbc:mysql://localhost:3306/STU";//"jdbc:Oracle:thin:@localhost:1521:orcl";
    private static String user="root";
    private static String psw="root";
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    //静态代码块 类加载到时候执行
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    private Utils(){

    }

    /**
     * 获取数据库到连接
     * @return conn
     */
    public static Connection getConnection(){
        if (null==con){
            try{
                con= DriverManager.getConnection(url,user,psw);
                System.out.println("连接成功！");
            }catch (SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return con;
    }
    /**
     * 释放资源

     */
    public static void closeResources(Connection con,PreparedStatement ps,ResultSet rs){
        if (null !=rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally {
                if (null !=ps){
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }finally {
                        if (null !=con){
                            try {
                                con.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }
    }
}