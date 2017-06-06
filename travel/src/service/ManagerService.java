package service;

import dao.ManagerDao;
import domain.Manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.ManagerDao.selectAllByName;

/**
 * Created by Administrator on 2017/4/27.
 */
public class ManagerService {
    private static ManagerDao md = new ManagerDao();
    static Manager manager = new Manager();

    //注册功能
    //参数：用户信息（除序号）
    //返回值：0：注册成功；1：注册失败
    public int loadIn(Manager manager ) throws SQLException, ClassNotFoundException {
        return md.insert(manager);
    }

    //登录功能
    //参数：用户信息（只有姓名有用）
    //返回值：(int)1.无此用户；2.可以登录；3.密码不对
    public int loginIn(Manager thisManager) throws SQLException, ClassNotFoundException{
        //测试
        System.out.println("管理员service验证");
        List<Manager> forPass = new ArrayList<>();
        forPass = md.selectAllByName(thisManager.getM_NAME());
        System.out.println("MS用来查询的姓名："+thisManager.getM_NAME());
        if(forPass.size() == 0) return 1; //无此用户
        for(int i=0; i < forPass.size(); i++){
            manager = forPass.get(i);
            //测试
            System.out.println(manager.getM_ID()+" "+manager.getM_NAME()+" "+manager.getM_PASS_WORD());
            if((manager.getM_PASS_WORD()).equals(thisManager.getM_PASS_WORD())) return 2; //可以登录
        }
        return 3; //密码不对
    }

    //根据姓名查找返回用户信息
    public static void findAll() throws SQLException, ClassNotFoundException {
        List<Manager> list = selectAllByName(manager.getM_NAME());
        for (Manager m: list) {
            System.out.println(m.toString());
        }
    }

}
