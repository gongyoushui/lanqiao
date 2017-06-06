package dao;

import domain.Manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */
public class ManagerDao {

    //按照姓名查找
    public static List<Manager> selectAllByName(String name) throws SQLException, ClassNotFoundException {
       // Class.forName("oracle.jdbc.OracleDriver");
        List<Manager> all = new ArrayList<>();
        ConnUtil connUtil =new ConnUtil();

        System.out.println("查询语句的名字:"+name);
        String sql = "SELECT * FROM MANAGER WHERE M_NAME = ?";
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);

        ps.setString(1, name);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            Manager d = new Manager();
            System.out.println("test");
            d.setM_ID(resultSet.getInt(1));
            d.setM_NAME(resultSet.getString(2));
            d.setM_PASS_WORD(resultSet.getString(3));

        /*测试-从数据库中已取出*/
            System.out.println(d.getM_ID()+" "+d.getM_NAME()+" "+d.getM_PASS_WORD());
            all.add(d);
        }
       connUtil.getClose(ps);

        return all;
    }

    //插入(这个可能不需要)
    public static int  insert(Manager manager) throws ClassNotFoundException{

        ConnUtil connUtil =new ConnUtil();
        String sql = "insert into MANAGER(M_ID,M_NAME,M_PASS_WORD) VALUES (manager_SEQ.nextval,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connUtil.getConn().prepareStatement(sql);
            // ps.setInt(1,U_id);
            ps.setString(1,manager.getM_NAME());
            ps.setString(2,manager.getM_PASS_WORD());

            int result = ps.executeUpdate();
            System.out.println("resut: " +result  );

            connUtil.getClose(ps);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    //删除
    public static int delete(String name ) throws SQLException, ClassNotFoundException {
        ConnUtil connUtil =new ConnUtil();

        String sql = "delete from manager where M_NAME=?";
        PreparedStatement ps =  connUtil.getConn().prepareStatement(sql);

        ps.setString(1, name);

        int result  = ps.executeUpdate();
        System.out.println("resut: " +result  );


        connUtil.getClose(ps);
        return result;
    }

    //修改密码
    public static int updatePasswordByName(Manager manager) throws SQLException{
        ConnUtil connUtil =new ConnUtil();
        String sql = "update MANAGER set M_PASS _WORD = ?   where M_NAME = ?";
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);
        ps.setString(1,manager.getM_PASS_WORD());
        ps.setString(2,manager.getM_NAME());

        int result = ps.executeUpdate();
        System.out.println("result" + result);

      connUtil.getClose(ps);
        return result;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        selectAllByName("jjj");
//      delete("z");
        //delete("jjjjj");

    }

}
