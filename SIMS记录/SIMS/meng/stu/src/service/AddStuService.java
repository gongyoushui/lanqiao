package service;

import bean.Stu;
import dao.AddDao;
import dao.AddDaoImpl;

/**
 * Created by lanqiao on 2017/5/25.
 */
public class AddStuService {
    public int addSs(Stu stu){
        AddDao ad =new AddDaoImpl();
        int rs= ad.addStudent(stu);
        return rs;
    }
}
