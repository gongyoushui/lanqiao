package service;

import dao.FoodsDao;
import domain.FoodCommend;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/4/29.
 */
public class FoodsService {

    private static FoodsDao foodsDao = new FoodsDao();
    //获取推荐美食
    public static List<FoodCommend> recommendAll(int s_id) throws SQLException {
        return foodsDao.recommend(s_id);
    }

    //获取通过搜索出现的美食信息
    public static List<FoodCommend> findFood(String name) throws SQLException {
        return foodsDao.selectAllByName(name);
    }
    public static List<FoodCommend> findType(String type) throws SQLException {
        return foodsDao.selectAllByType(type);

    }
}

