package dao;

import bean.Adi;

import java.util.List;

/**
 * Created by lanqiao on 2017/5/24.
 */
public interface LoginDao {
    public boolean findUserByName(Adi adi);
}
