package service;

/**
 * Created by lanqiao on 2017/6/4.
 */
public class something {
    void metho(){
        String[][] manager = {{"成绩统计分析","考试列表"},{"学生信息管理","学生列表"},{"教师信息管理","教师列表"},{"基础信息管理","年级列表","年级列表","课程列表"},{"系统管理","系统设置"}};
        String[][] teacher = {{"教学管理","成绩登记"},{"教师信息","教师通讯录"},{"系统管理","个人信息"}};
        String[][] student = {{"教学管理","成绩查询"},{"班级信息","班级通讯录"},{"系统管理","个人信息"}};
        String[][] select = manager;
        for(int i=0; i<select.length;i++){
            System.out.println("1");
        }
    }
    void main(){
        metho();
    }
}
