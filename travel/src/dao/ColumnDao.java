package dao;

import domain.Column;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColumnDao { //管理员操作所有表的地方

    //查找全部表名
    public List<String> selectAllTableName() throws SQLException, ClassNotFoundException {
        List<String> all = new ArrayList<>();
        ConnUtil connUtil =new ConnUtil();

        String sql = "select tables.table_name from user_tables tables ";
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            all.add(resultSet.getString(1));
        }
        connUtil.getClose(ps);

        return all;
    }

    //根据表名选则显示表项
    public static List<String> showTables(String tableName) throws SQLException, ClassNotFoundException {
        // Class.forName("oracle.jdbc.OracleDriver");
        List<String> all = new ArrayList<>();
        ConnUtil connUtil = new ConnUtil();

        System.out.println("ColumnDao"+tableName);
        if(tableName == null) {
            System.out.println("test");
            tableName = "USERS";
        }
        String sql = "SELECT * FROM "+tableName;
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        //检索此 ResultSet 对象的列的编号、类型和属性。
        ResultSetMetaData rsmd = rs.getMetaData();
        //得到当前的列数
        int colCount = rsmd.getColumnCount();
        //将元素作为String类型传过去
        //得到当前列的列名
        String names = "";
        for (int i = 1; i <= colCount; i++) { //for循环控制列数
            String name = rsmd.getColumnName(i);
            if(i > 1)
                names = names+",";
            names = names + name;
        }
        all.add(names);
        //得到当前列的值
        String values = "";
        while (rs.next()) { //while控制行数
            values = "";
            for (int i = 1; i <= colCount; i++) { //for循环控制列数
                String value = rs.getString(i);
                if(i > 1)
                    values = values + ",";
                values = values + value;
            }
            all.add(values);
        }
        connUtil.getClose(ps);
        return all;
    }

    //插入
    //参数：tableName:表名；columnNames:列名；datas:插入的数据
    public int insert(String tableName, String[] columnNames,String[] datas) throws ClassNotFoundException, SQLException {

        ConnUtil connUtil =new ConnUtil();
        //检索此 ResultSet 对象的列的编号、类型和属性。
        String sql = "SELECT * FROM "+tableName;
        PreparedStatement ps = connUtil.getConn().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        String columnNameSql = ""; //列名
        String dataSql = ""; //传过来的数据
        for(int i=0; i < columnNames.length-1; i++){
            //表项的组合
            if(i > 0){
                columnNameSql += ",";
               dataSql += ",";
            }
            columnNameSql += columnNames[i];
            dataSql += "?";
        }
        columnNameSql += ","+columnNames[columnNames.length-1];
        sql = "insert into "+tableName+"("+columnNameSql+") VALUES ("+tableName+"_SEQ.nextval,"+dataSql+")"; //这个序列可能还没做
        ps = connUtil.getConn().prepareStatement(sql);
        for(int i= 1;i< datas.length; i++) {
            int jug = rsmd.getColumnType(i+1); //返回该列的属性的代号
            System.out.println(datas[i]+" jug:"+jug);
            if(jug == 12) //2:varchar2,12:number
                ps.setString(i,datas[i]);
            else if(jug == 2)
                ps.setInt(i,Integer.parseInt(datas[i]));
        }
        System.out.println("sql:"+sql);
        int result = ps.executeUpdate();
        System.out.println("resut: " +result);

        connUtil.getClose(ps);
        return result;
    }

    //删除
    //参数：tableName:表名；columnName:列名；position:行
    //返回值：>0时成功
    public static int delete(String tableName, String columnName, int position) throws ClassNotFoundException {
        ConnUtil connUtil =new ConnUtil();
        String sql = "delete from "+tableName+" where "+columnName+"= ? ";
        PreparedStatement ps = null;
        try {
            ps = connUtil.getConn().prepareStatement(sql);
            ps.setInt(1, position);
            System.out.println("delete sql:"+sql+"...position"+position);

            int result  = ps.executeUpdate();
            System.out.println("resut: " +result  );

            connUtil.getClose(ps);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
