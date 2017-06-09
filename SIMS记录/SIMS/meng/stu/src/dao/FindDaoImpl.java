package dao;

import bean.Stu;
import utils.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanqiao on 2017/5/25.
 */
public class FindDaoImpl implements FindDao{
    @Override
    public List<Stu> findStudent(){
        Connection conn= Util.getConnection();
        String sql="select stu_name,stu_status from stu";
        List<Stu> stus = new ArrayList<>();
        try{
            PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                Stu stu1 = new Stu(rs.getString(1),rs.getString(2));
                stus.add(stu1);
                // stus.add(rs.getNString(1));
                // stus.add(rs.getNString(2));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return stus;
    }

}
