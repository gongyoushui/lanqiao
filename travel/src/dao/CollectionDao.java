package dao;

import domain.Sight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/1.
 * 收藏
 */
public class CollectionDao {
    //根据用户ID(U_ID) 表ID(C_ID),表内容ID(C_SON)  插入相应收藏景点/美食/住宿信息
    public static int  insert(int u_id,int c_id, String c_name) throws SQLException {
        ConnUtil connUtil = new ConnUtil();
        String sql = "insert into USER_COLLECTION " +
                     "VALUES (USER_COLLECTION_SEQ.nextval,?,?,?)";

        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);
        ps.setInt(1,u_id);
        ps.setInt(2,c_id);
        ps.setString (3,c_name);

        int  result= ps.executeUpdate();
        System.out.println("resut: " +result  );

        connUtil.getClose(ps);

        return result;
    }


    //根据用户信息 (根据用户ID显示显示景点的信息)搜索收藏表Sight中信息
    public static List<Sight> showMsg(int u_id) throws SQLException {
        List<Sight> msg = new ArrayList<>();
        ConnUtil connUtil = new ConnUtil();
        String sql = "select s.S_NAME,s.S_INTRODUCTION,s.S_LEVEL,s.S_LOC,S_SUM_ESSAY" +
                     " from SIGHT s where S_name in " +
                     "( select C_NAME from USER_COLLECTION uc  where uc.c_id = 1 and uc.U_ID=? ) ";
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);
        ps.setInt(1,u_id);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
             Sight sight = new Sight();
             sight.setS_NAME(resultSet.getString(1));
             sight.setS_INTRODUCTION(resultSet.getString(2));
             sight.setS_lEVEL(resultSet.getString(3));
             sight.setS_LOC(resultSet.getString(4));
             sight.setS_SUM_ESSAY(resultSet.getString(5));

             msg.add(sight);
        }
        return msg;
    }


    //判断表中是否存在已经收藏的信息(未使用)
    public static boolean isExist(String name) throws SQLException {
        ConnUtil connUtil = new ConnUtil();
        String sql = "select 0 from USER_COLLECTION where C_NAME= ?";
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);
        ps.setString(1,name);
        ResultSet result = ps.executeQuery();
        if(result != null ){
            return false;
        }
        return true;
    }

    //

    public static void main(String[] args) throws SQLException {
        //insertSight(1,1,);
    }

}
