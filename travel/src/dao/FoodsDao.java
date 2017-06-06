package dao;

import domain.FoodCommend;
import domain.Foods;
import domain.Sight;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/29.
 */
public class FoodsDao {
    //景点周边美食推荐(参数:景点ID)
    public static List<FoodCommend> recommend (int s_id) throws SQLException {
       // List<Foods> msg = new ArrayList<>();
        List<FoodCommend> msg = new ArrayList();

        ConnUtil connUtil = new ConnUtil();
        String sql = "SELECT  si.s_name,S_NAME,f.F_NAME,f.F_PRICE,s.STO_NAME,f.F_DISCOUNT,f.F_PIC" +
                    " from FOODS f join STORE s on (f.STO_ID= s.STO_ID)" +
                    "join SIGHT si on(s.S_ID= si.S_ID )" +
                    "where si.S_ID = ?" +
                    "order by (nvl(f.F_DISCOUNT,0) )desc";
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);
        ps.setInt(1,s_id);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()){
           // Foods foods = new Foods();
            FoodCommend commend = new FoodCommend();
            commend.setSi_name(resultSet.getString(1));
            commend.setS_name(resultSet.getString(2));
            commend.setF_name(resultSet.getString(3));
            commend.setF_price(resultSet.getInt(4));
            commend.setSto_name(resultSet.getString(5));
            commend.setF_discount(resultSet.getInt(6));
            commend.setF_pic(resultSet.getString(7));

            msg.add(commend);
        }

        connUtil.getClose(ps);
        return msg;
    }

    //按照美食名查找美食信息(西餐名)
    public static List<FoodCommend> selectAllByName(String name) throws SQLException {
        ConnUtil connUtil = new ConnUtil();
        List<FoodCommend> msg = new ArrayList();

        String  sql = "SELECT  si.s_name,f.F_NAME,f.F_PRICE,s.STO_NAME,f.F_DISCOUNT ,F_TYPE " +
                      "from FOODS f join STORE s on (f.STO_ID= s.STO_ID)" +
                      "join SIGHT si on(s.S_ID= si.S_ID )" +
                      "where f.F_NAME like ?";

        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);
        ps.setString(1,name+"%");

        ResultSet resultSet = ps.executeQuery();

        while(resultSet.next() ){
            FoodCommend foodCommend = new FoodCommend();
            foodCommend.setSi_name(resultSet.getString(1));
            foodCommend.setF_name(resultSet.getString(2));
            foodCommend.setF_price(resultSet.getInt(3));
            foodCommend.setSto_name(resultSet.getString(4));
            foodCommend.setF_discount(resultSet.getInt(5));
            foodCommend.setF_type(resultSet.getString(6));

            msg.add(foodCommend);
        }
        connUtil.getClose(ps);
        return msg;
    }


    //按类型搜索美食信息
    public static List<FoodCommend> selectAllByType(String type) throws SQLException {
        List<FoodCommend> msg = new ArrayList<>();
        ConnUtil connUtil = new ConnUtil();
        String sql = " select si.s_name,f.F_NAME,f.F_PRICE,s.STO_NAME,f.F_DISCOUNT " +
                     "from FOODS f join STORE s on (f.STO_ID= s.STO_ID)" +
                     "join SIGHT si on(s.S_ID= si.S_ID )" +
                     "where f.f_type = ?";
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);

        ps.setString(1,type);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            FoodCommend foodCommend = new FoodCommend();
            foodCommend.setSi_name(resultSet.getString(1));
            foodCommend.setF_name(resultSet.getString(2));
            foodCommend.setF_price(resultSet.getInt(3));
            foodCommend.setSto_name(resultSet.getString(4));
            foodCommend.setF_discount(resultSet.getInt(5));

            msg.add(foodCommend);

        }
        connUtil.getClose(ps);
        return msg;
    }
}
