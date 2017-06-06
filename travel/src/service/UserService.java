package service;

import dao.UserDao;
import domain.Users;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.UserDao.selectAllByName;

/**
 * Created by Administrator on 2017/4/26.
 */

public class UserService {
    private static UserDao ud = new UserDao();
    public static Users  user ;

    //注册功能
    //参数：用户信息（除序号）
    //返回值：0：注册成功；1：注册失败
    public int loadIn(Users user ) throws SQLException, ClassNotFoundException {
        return ud.insert(user);
    }
    //根据姓名查找返回用户信息
    public static List<Users> findUserMsg(String name) throws SQLException, ClassNotFoundException {
        return ud.selectAllByName(name);
    }

    //获取用户ID
//    public int getU_id(String name) throws Exception {
//        return ud.searchU_id(name);
//    }
    //登录功能
    //参数：用户信息（只有姓名有用）
    //返回值：(int)1.无此用户；2.可以登录；3.密码不对
    public int loginIn(Users thisUser) throws SQLException, ClassNotFoundException{
        //测试
        System.out.println("service验证");
        List<Users> forPass = new ArrayList<>();
        forPass = ud.selectAllByName(thisUser.getU_NAME());
        if(forPass.size() == 0) return 1; //无此用户
        for(int i=0; i < forPass.size(); i++){
            user = forPass.get(i);
            //测试
            System.out.println(user.getU_ID()+" "+user.getU_NAME()
                    +" "+user.getU_PASS_WORD()+" "+user.getU_PHONE_NUM());
            if((user.getU_PASS_WORD()).equals(thisUser.getU_PASS_WORD())) return 2; //可以登录
        }
        return 3; //密码不对
    }



    //修改密码(由手机号验证)
    //参数:user-确认信息，pass-确认密码
    //返回值：(int)-1：确认密码不符合；-2：手机号不符合；0：无此用户；大于0：修改成功
    public int changePassword(Users inUser, String pass) throws SQLException, ClassNotFoundException {
        System.out.println("service:修改密码功能：");
        List<Users> forChange = new ArrayList<>();
        forChange = ud.selectAllByName(inUser.getU_NAME());
        if (!inUser.getU_PASS_WORD().equals(pass)) {//确认密码不符合
            System.out.println("service:确认密码错误");
            return -1;
        }
        if(forChange.size() == 0) {
            System.out.println("service:无此用户");
            return 0; //无此用户
        }
        for(int i=0; i < forChange.size(); i++){
            System.out.println("service：正在对比该用户的手机号");
            user = forChange.get(i);
            //测试
            System.out.println(user.getU_ID()+" "+user.getU_NAME()+" "+user.getU_PASS_WORD()+" "+user.getU_PHONE_NUM());
            if(user.getU_PHONE_NUM() == inUser.getU_PHONE_NUM()) //可以修改密码
                System.out.println("service：有对应用户");
                return ud.updatePasswordByName(inUser);
        }
        System.out.println("service:手机号不对应");
        return -2; //手机号不对
    }

    //忘记密码(由手机号验证)
    //参数:user-确认信息
    //返回值：(Users) null:信息有问题；成功：密码信息
    public Users findPassword(Users inUser) throws SQLException, ClassNotFoundException{
        System.out.println("忘记密码功能：");
        List<Users> forChange = new ArrayList<>();
        forChange = ud.selectAllByName(inUser.getU_NAME());
        if(forChange.size() == 0) {
            System.out.println("service:无此用户");
            return null; //无此用户
        }
        for(int i=0; i < forChange.size(); i++){
            System.out.println("service：正在对比该用户的手机号");
            user = forChange.get(i);
            //测试
            System.out.println(user.getU_ID()+" "+user.getU_NAME()+" "+user.getU_PASS_WORD()+" "+user.getU_PHONE_NUM());
            if(user.getU_PHONE_NUM() == inUser.getU_PHONE_NUM()){//可以修改密码
                System.out.println("service:可以提示密码");
                return user;
            }
        }
        System.out.println("service:没有符合此用户的手机号");
        return null;
    }
}
