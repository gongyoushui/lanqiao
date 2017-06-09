package dao;

import bean.Stu;
import utils.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by lanqiao on 2017/5/25.
 */
public class AddDaoImpl implements AddDao{
    @Override
    public int addStudent(Stu stu) {
        System.out.println("-----------");
        System.out.println(stu.getStu_status());
        System.out.println(stu.getStu_name());
        System.out.println("-----------");



        Connection conn = Util.getConnection();

        String sql = "INSERT INTO stu (stu_name,stu_pwd,stu_status) VALUES(?,?,?)";

        int result=0;

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, stu.getStu_name());
            pst.setString(2, stu.getStu_pwd());
            pst.setString(3, stu.getStu_status());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
