package dao;

import bean.Stu;
import utils.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by lanqiao on 2017/5/31.
 */
public class UpdateDaoImpl implements UpdateDao{
    @Override
    public int updateStudent(Stu stu){
        System.out.println("----------");
        System.out.println(stu.getStu_name());
        System.out.println(stu.getStu_pwd());
        System.out.println(stu.getStu_status());

        Connection conn = Util.getConnection();

        String sql="UPDATE stu SET stu_name=?,stu_pwd=?,stu_status=?";

        int result=0;
        try{
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,stu.getStu_name());
            pst.setString(2,stu.getStu_pwd());
            pst.setString(3,stu.getStu_status());
            result = pst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
