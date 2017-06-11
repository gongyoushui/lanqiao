package demo;

import utils.DbHelper;

import java.io.*;
import java.sql.*;

public class Photo extends DbHelper{
    public static void main(String[] args) {
        //负责连接MySQl数据库的类
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream in = null;
        try {
            //从本地硬盘硬盘读取一张图片保存到数据库
            con = getConnction();
            in = new FileInputStream("sdf.png");
            ps = con.prepareStatement("insert into test.phototest values(?,?)");
            ps.setInt(1, 2);
            ps.setBinaryStream(2, in, in.available());
            ps.executeUpdate();
            in.close();
            closeAll();
            //从数据库读取图片保存到本地硬盘
            con = getConnction();
            ps = con.prepareStatement("select * from test.phototest where id=?");
            ps.setInt(1, 2);
            rs = ps.executeQuery();
            rs.next();
            //将光标指向第一行
            in = rs.getBinaryStream("photo");
            byte[] b = new byte[in.available()];
            //新建保存图片数据的byte数组
            in.read(b);
            OutputStream out = new FileOutputStream("222.jpg");

            out.write(b);
            out.flush();
            out.close();
            closeAll();
        } catch
                (Exception e) {
            System.out.println("Error::" + e);
        }
    }
}