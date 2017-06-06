package dao;

import domain.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 */
public class UserDao {

//按照姓名查找
    public static List<Users> selectAllByName(String name) throws SQLException, ClassNotFoundException {
        List<Users> all = new ArrayList<>();
        ConnUtil connUtil =new ConnUtil();

        String sql = "SELECT U_id, U_PHONE_NUM,U_PASS_WORD FROM USERS WHERE U_name = ?";
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);

        ps.setString(1, name);
        ResultSet resultSet = ps.executeQuery();
        //测试
        ResultSetMetaData rsmd = resultSet.getMetaData();
        System.out.println("rsmd:"+rsmd.getColumnType(1)+","+rsmd.getColumnType(2)+","+rsmd.getColumnType(3));
        while (resultSet.next()) {
            Users d = new Users();
            d.setU_ID(resultSet.getInt(1));
            d.setU_PHONE_NUM(resultSet.getInt(2));
            d.setU_PASS_WORD(resultSet.getString(3));
            all.add(d);
        }
       connUtil.getClose(ps);

        return all;
    }

    //插入
    public static int  insert(Users user) throws ClassNotFoundException, SQLException {

        ConnUtil connUtil =new ConnUtil();

        String sql = "insert into users(U_ID,U_NAME,U_PASS_WORD,U_PHONE_NUM) " +
                     "VALUES (userid_SEQ.nextval,?,?,?)";
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);
        ps.setString(1,user.getU_NAME());
        ps.setString(2,user.getU_PASS_WORD());
        ps.setInt(3,user.getU_PHONE_NUM());

        int result = ps.executeUpdate();
        System.out.println("resut: " +result  );

        connUtil.getClose(ps);
        return result;

    }

    //删除
    public static int delete(String name ) throws SQLException, ClassNotFoundException {
    ConnUtil connUtil =new ConnUtil();

    String sql = "delete from users where U_NAME=?";
    PreparedStatement ps =  connUtil.getConn().prepareStatement(sql);

    ps.setString(1, name);

    int result  = ps.executeUpdate();
    System.out.println("resut: " +result  );
    connUtil.getClose(ps);
    return result;
}

    //修改密码
    public static int updatePasswordByName(Users thisUser) throws SQLException, ClassNotFoundException {
        System.out.println("userDao:修改密码");
        ConnUtil connUtil = new ConnUtil();
        String sql = " UPDATE USERS set U_PASS_WORD = ? where U_NAME = ? AND U_PHONE_NUM = ? ";
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);
        //测试
        System.out.println("thisUser:"+thisUser.getU_PASS_WORD());
        ps.setString(1,thisUser.getU_PASS_WORD());
        ps.setString(2,thisUser.getU_NAME());
        ps.setInt(3,thisUser.getU_PHONE_NUM());

        int result = ps.executeUpdate();
        System.out.println("result" + result);
        connUtil.getClose(ps);
        return result;
    }







    //查询U_id(未使用)
    public int searchU_id(String name ) throws Exception {
        ConnUtil connUtil =new ConnUtil();

        String sql = "SELECT U_id FROM USERS WHERE U_name = ?";
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);

        ps.setString(1, name);

        ResultSet resultSet = ps.executeQuery();
        int U_id =-11;
        while (resultSet.next()) {
            U_id= resultSet.getInt(1);
        }
        connUtil.getClose(ps);
        return U_id;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//      delete("z");
     delete("jjjjj");

    }
}
