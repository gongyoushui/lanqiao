package service;

import bean.Stu;
import dao.UpdateDao;
import dao.UpdateDaoImpl;

/**
 * Created by lanqiao on 2017/5/31.
 */
public class UpdateStuService {
    public int upSs(Stu stu){
        UpdateDao up =new UpdateDaoImpl();
        int ups = up.updateStudent(stu);
        return ups;
    }
}
