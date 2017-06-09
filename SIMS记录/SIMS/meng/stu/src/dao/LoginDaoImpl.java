package dao;

import bean.Adi;
import bean.Stu;
import utils.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanqiao on 2017/5/24.
 */
public class LoginDaoImpl implements LoginDao{
    @Override
    public boolean findUserByName(Adi adi) {
        Boolean flag=false;
        Connection conn= Util.getConnection();
        String sql="select * from adi where adi_name=? and adi_pwd=?";
        try {
            PreparedStatement pst= conn.prepareStatement(sql);
            pst.setString(1,adi.getAdi_name());
            pst.setString(2,adi.getAdi_pwd());
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //end

        return flag;
    }
}

