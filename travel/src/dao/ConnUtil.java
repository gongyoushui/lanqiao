package dao;

import java.sql.*;

/**
 * Created by Administrator on 2017/4/26.
 */
public class ConnUtil {
    public  Connection getConn()
    {
        String driver = "oracle.jdbc.OracleDriver";
        String url = "jdbc:oracle:thin:@192.168.100.252:1521:XE";
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");// 动态加载mysql驱动
/*测试*/			//System.out.println("成功加载Oracle驱动程序");

            conn = DriverManager.getConnection(url,"JJ","admin");
        } catch (Exception e) {
/*测试*/			System.out.print("数据库连接异常");
            e.printStackTrace();
        }
            return conn;

    }
    //Connection conn, Statement stat, ResultSet rs
    //关闭数据库连接
    public void getClose(PreparedStatement stat){
        try {
            ConnUtil connUtil =new ConnUtil();
            Connection conn =connUtil.getConn();
            if(conn!=null){
                conn.close();
            }
            if(stat!=null){
                stat.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
