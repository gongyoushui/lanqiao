package service;

import dao.CollectionDao;
import domain.Sight;
import domain.Users;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/1.
 */
public class CollectionService {

   static CollectionDao cd = new CollectionDao();

   //添加收藏(根据用户ID  u_id)
    public static int  add(int u_id, int c_id, String c_name) throws SQLException {
            return cd.insert(u_id, c_id, c_name);
    }

    //显示用户收藏信息
    public static List<Sight> getCollectMsg(int u_id) throws SQLException {
        return cd.showMsg(u_id);
    }
}
