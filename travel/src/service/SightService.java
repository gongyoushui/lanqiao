package service;

import dao.SightDao;
import domain.Sight;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 */
public class SightService {

    private static SightDao sd = new SightDao();

    public static List<Sight> commendAll() throws SQLException, ClassNotFoundException {
        return sd.recommend ();
    }

    public static List<Sight> findSight(String name) throws SQLException, ClassNotFoundException {
        return sd.preview(name);
    }



}
