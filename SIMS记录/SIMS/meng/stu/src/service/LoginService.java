package service;

import bean.Adi;
import dao.LoginDao;
import dao.LoginDaoImpl;

/**
 * Created by lanqiao on 2017/5/24.
 */
public class LoginService {
    public Boolean findUserByUser(Adi adi){
        LoginDao ld= new LoginDaoImpl();
        Boolean b= ld.findUserByName(adi);
        return b;
    }
}
