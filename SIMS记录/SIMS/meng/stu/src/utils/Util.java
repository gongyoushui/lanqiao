package utils;

import java.sql.*;

/**
 * Created by lanqiao on 2017/5/24.
 */
public class Util {
    private static String url="jdbc:mysql://localhost:3306/AdminUser";
    private static String user="root";
    private static String psw="root";

    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    //静态代码块，类加载的时候执行

    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Util(){}

    public static Connection getConnection(){
        if(conn==null){
            try{
                conn= DriverManager.getConnection(url,user,psw);
                System.out.println("连接成功！");
            }catch(SQLException e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    public static void closeResources(Connection conn,PreparedStatement ps,ResultSet rs){
        if(rs!=null){
            try{
                rs.close();
            }catch(SQLException e){e.printStackTrace();
            throw new RuntimeException(e);
            }finally {
                if(ps!=null){
                    try {
                        ps.close();
                    }catch(SQLException e){e.printStackTrace();
                    throw new RuntimeException(e);
                    }finally {
                        if(conn!=null){
                            try{
                                conn.close();
                            }catch (SQLException e){e.printStackTrace();
                            throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }
    }
}
