package dao;


import bean.*;
import utils.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7 0007.
 */
public class StudentDao {
    //通过学生姓名查询某个学生的全部信息
    public Student findStudent(String student_name){
        Connection connection = Util.getConnection();

        String sql = "SELECT student_name,student_code,sex,phone,qq,mail,tips FROM STUDENT WHERE student_name =?";
        Student student =null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setNString(1,student_name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                student= new Student();
                student.setStudent_name(rs.getString(1));
                student.setStudent_code(rs.getString(2));
                student.setSex(rs.getString(3));
                student.setPhone(rs.getString(4));
                student.setQq(rs.getInt(5));
                student.setMail(rs.getString(6));
                student.setTips(rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    //更改登录学生信息
    public int updateStudent(Student student,String student_name){
        Connection connection=Util.getConnection();
        String sql="UPDATE STUDENT SET sex=?,phone=?,qq=?,mail=?,tips=? WHERE student_name =?;";
        int result = 0;
        try {
            PreparedStatement ps=connection.prepareStatement(sql);

            ps.setString(1,student.getSex());
            ps.setString(2,student.getPhone());
            ps.setInt(3,student.getQq());
            ps.setString(4,student.getMail());
            ps.setString(5,student.getTips());
            ps.setString(6,student_name);
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //更改密码
    public int updatePassword(String user_code){
        Connection connection=Util.getConnection();
        String sql="UPDATE user SET user_pass=? WHERE user_code=?;";
        User user=new User();
        int result=0;
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,user.getUser_pass());
            ps.setString(2,user_code);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //查询考试信息
    public List<SelectExam> findAllExam(String exam_name){
        Connection connection=Util.getConnection();
        String sql="SELECT exam_name,time,type,exam_grade,exam_class,lesson_name\n" +
                "  FROM exam,lesson\n" +
                "  WHERE exam.lesson_id=lesson.lesson_id AND exam_name=?;";
        List<SelectExam> selectExams=new LinkedList<>();
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,exam_name);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                SelectExam selectExam=new SelectExam();
                selectExam.getExam().setExam_name(rs.getString(1));
                selectExam.getExam().setTime(rs.getString(2));
                selectExam.getExam().setType(rs.getString(3));
                selectExam.getExam().setExam_grade(rs.getString(4));
                selectExam.getExam().setExam_class(rs.getString(5));
                selectExam.getLesson().setLesson_name(rs.getString(6));
                selectExams.add(selectExam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selectExams;
    }

}
