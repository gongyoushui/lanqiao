package service;

import dao.ColumnDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/2.
 */
public class ColumnService {
    private ColumnDao cd = new ColumnDao();
    //显示所有表名
    public List<String> showTableName() throws SQLException, ClassNotFoundException {
        return cd.selectAllTableName();
    }

    //根据表名显示表
    public List<String> showTables(String tableName) throws SQLException, ClassNotFoundException {
        return cd.showTables(tableName);
    }

    //删除表
    public int delete(String tableName, String columnName,int position) throws ClassNotFoundException {
        return cd.delete(tableName, columnName, position);
    }

    //增加项
    public int insert(String tableName, String[] columnNames,String[] datas) throws SQLException, ClassNotFoundException {
        return cd.insert(tableName, columnNames, datas);
    }
}
