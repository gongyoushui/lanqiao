package service;

import bean.Stu;
import dao.FindDao;
import dao.FindDaoImpl;
import dao.LoginDao;
import dao.LoginDaoImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanqiao on 2017/5/25.
 */
public class FindStuService {
   public List<Stu> FindSs(){
       FindDao fd = new FindDaoImpl();
       List<Stu> students =fd.findStudent();
       return students;
   }
}
