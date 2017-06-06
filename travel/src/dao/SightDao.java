package dao;

import domain.Sight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 */
public class SightDao {

    //显示景点基本信息
    public static List<Sight> preview(String name) throws ClassNotFoundException, SQLException {
        List<Sight> msg = new ArrayList<>();
        ConnUtil connUtil =new ConnUtil();

        String sql = "select s_loc,S_INTRODUCTION,S_PRICE,S_LEVEL,S_SUM_ESSAY,S_PIC,S_name " +
                     " from SIGHT " +
                     "where S_NAME like ?";
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);
        ps.setString(1,name+"%");

        ResultSet resultSet = ps.executeQuery();

        while(resultSet.next()){
        Sight sight = new Sight();
        sight.setS_LOC(resultSet.getString(1));
        sight.setS_INTRODUCTION(resultSet.getString(2));
        sight.setS_PRICE(resultSet.getInt(3));
        sight.setS_lEVEL(resultSet.getString(4));
        sight.setS_SUM_ESSAY(resultSet.getString(5));
        sight.setS_PIC(resultSet.getString(6));
        sight.setS_NAME(resultSet.getString(7));

        msg.add(sight);

    }
        connUtil.getClose(ps);
        return msg;
    }

    //用户登录界面景点推荐
    public static List<Sight> recommend () throws ClassNotFoundException, SQLException {
        List<Sight> msg = new ArrayList<>();
        ConnUtil connUtil =new ConnUtil();

        String sql = "select * " +
                "from (select * from SIGHT order by S_SUM_ESSAY  desc) " +
                "where rownum < 5";

        PreparedStatement ps =  connUtil.getConn().prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            Sight sight = new Sight();
            sight.setS_ID(resultSet.getInt(1));
            sight.setS_NAME(resultSet.getString(2));
            sight.setS_LOC(resultSet.getString(3));
            sight.setS_PRICE(resultSet.getInt(4));
            sight.setS_INTRODUCTION(resultSet.getString(5));
            sight.setS_SUM_ESSAY(resultSet.getString(6));
            sight.setS_PIC(resultSet.getString(7));
            sight.setS_lEVEL(resultSet.getString(8));

            msg.add(sight);
        }

       connUtil.getClose(ps);
        return msg;

    }
}


