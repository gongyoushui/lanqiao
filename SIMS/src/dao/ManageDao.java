package dao;

import bean.*;
import utils.DbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 * 此为管理员使用的dao
 */
public class ManageDao {

    //------------------------------------------------学生列表--------------------------------------------------
    //--------------------------------------------1、管理员查询学生信息---------------------------------------------
    //所用表：student、classes
    //点击管理员下的学生列表时，查询所有学生信息以显示，用到了student，classes两个表，查询了student中大部分信息，以及因为student表中没有班级名称，故用了student表中class_id及classes表中class_id连接以获取班级名
    public List<XSLB> findAllStudent(){
        Connection conn = DbHelper.getConnction();
        String sql = "select student_name,student_code,sex,phone,qq,mail,class_name,grade_name from student,classes where student.class_id =classes.class_id";
        List<XSLB> list = new ArrayList<XSLB>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                //将查询出的数据放到student及classes中，将此两个对象进行封装，放到一个XSLB（学生列表）中，方便数据传输
                Student student = new Student();
                Classes classes = new Classes();
                XSLB xslb = new XSLB();

                student.setStudent_name(rs.getNString(1));
                student.setStudent_code(rs.getNString(2));
                student.setSex(rs.getNString(3));
                student.setPhone(rs.getNString(4));
                student.setQq(rs.getInt(5));
                student.setMail(rs.getNString(6));
                classes.setClass_name(rs.getNString(7));
                classes.setGrade_name(rs.getNString(8));

                xslb.setStudent(student);
                xslb.setClasses(classes);

                list.add(xslb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //------------------------------------------------2、查找所有年级名称-------------------------------------------
    //查找所有年级，用于添加学生页面、修改学生页面、教师设置课程页面的年级下拉框中内容显示
    //所用表：grade
    public Grade findAllGrade(){
        Connection conn = DbHelper.getConnction();
        String sql = "SELECT grade_name from grade";
        Grade grade = new Grade();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                grade.setGrade_name(rs.getNString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    //---------------------------------------------3、查找所有班级名----------------------------------------------
    //查找所有班级，用于用于添加学生页面、修改学生页面、教师设置课程页面的年级下拉框中内容显示
    //所用表：classes
    public Classes findAllClass(){
        Connection conn = DbHelper.getConnction();
        String sql = "select class_name from classes";
        Classes classes = new Classes();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                classes.setClass_name(rs.getNString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }

    //----------------------------------------------4、查找班级ID--------------------------------------------------
    //查找班级ID，添加学生信息时，添加的是班级名、年级名，而student表中需要的是班级ID（其中包含年级名、班级名）
    //所用表classes
    public Classes findClassId(Classes classes){
        Connection conn = DbHelper.getConnction();
        String sql = "select class_id from classes where class_name = ? and grade_name = ?";
        Classes cs = new Classes();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,classes.getClass_name());
            ps.setString(2,classes.getGrade_name());
            ResultSet resultSet = ps.executeQuery();
            classes.setClass_id(resultSet.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }

    //----------------------------------------------5、管理员添加学生信息--------------------------------------------
    //所用表：student
    public int addStudnet(Student student){
        Connection conn = DbHelper.getConnction();
        String sql = "INSERT INTO student(student_name, student_code, sex, class_id, phone, qq, mail) VALUE (?,?,?,?,?,?,?);";
        int result = -1;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,student.getStudent_name());
            ps.setString(2,student.getStudent_code());
            ps.setString(3,student.getSex());
            ps.setInt(4,student.getClass_id());
            ps.setString(5,student.getPhone());
            ps.setInt(6,student.getQq());
            ps.setString(7,student.getMail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //-------------------------------------------------6、添加用户信息----------------------------------------------
    //添加新用户（添加学生、教师时同时添加）
    //所用表：user
    public int addUser(User user){
        Connection conn = DbHelper.getConnction();
        String sql = "INSERT INTO user(user_code, user_pass, type) VALUE (?,?,?);";
        int result = -1;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUser_code());
            ps.setString(2,user.getUser_pass());
            ps.setInt(3,user.getType());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //-------------------------------------------------7、管理员修改学生信息----------------------------------------
    //修改学生信息
    //所用表：student
    public int updateStudent(Student student,String code){
        Connection conn = DbHelper.getConnction();
        String sql = "update student set student_name = ?,student_code = ?,sex = ?,class_id = ?,phone=?,qq=?,mail=?,tips=? where student_code = ?;";
        int result = -1;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,student.getStudent_name());
            ps.setString(2,student.getStudent_code());
            ps.setString(3,student.getSex());
            ps.setInt(4,student.getClass_id());
            ps.setString(5,student.getPhone());
            ps.setInt(6,student.getQq());
            ps.setString(7,student.getMail());
            ps.setString(8,student.getTips());
            ps.setString(9,code);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }

    //---------------------------------------8、管理员修改用户信息-------------------------------------------------
    //所用表:user
    public int updateUser(User user,String code){
        Connection conn = DbHelper.getConnction();
        String sql = "UPDATE user set user_code = ?, user_pass = ? where user_code = ?";
        int result = -1;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUser_code());
            ps.setString(2,user.getUser_pass());
            ps.setString(3,code);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  result;
    }

    //---------------------------------------9、管理员删除学生信息-------------------------------------------------
    //所用表：student
    public int deleteStudent(String code){
        Connection conn = DbHelper.getConnction();
        String sql = "delete from student where student_code = ?";
        int result = -1;
        try {
            PreparedStatement ps = conn .prepareStatement(sql);
            ps.setString(1,code);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //---------------------------------------------10、管理员删除用户信息-------------------------------------------
    //所用表：user
    public int deleteUser(String code){
        Connection conn = DbHelper.getConnction();
        String sql = "delete from user where user_code = ?";
        int result = -1;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,code);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //-----------------------------------------------教师列表-----------------------------------------------------
    //----------------------------------------1、管理员查询所有教师信息--------------------------------------------
    //所用表：teacher
    public List<Teacher> findAllTeacher(){
        Connection conn = DbHelper.getConnction();
        String sql = "select * from teacher";
        List<Teacher> list = new ArrayList<Teacher>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setTeacher_name(rs.getNString(1));
                teacher.setTeacher_code(rs.getNString(2));
                teacher.setSex(rs.getNString(3));
                teacher.setPhone(rs.getNString(4));
                teacher.setQq(rs.getInt(5));
                teacher.setMail(rs.getNString(6));
                teacher.setTips(rs.getNString(7));

                list.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //------------------------------------2、管理员添加教师信息--------------------------------------------------
    //所用表：
    public int addTeacher(Teacher teacher){
        Connection conn = DbHelper.getConnction();
        String sql = "INSERT INTO teacher(teacher_name, teacher_code, sex, phone, qq, mail, tips) VALUE (?,?,?,?,?,?,?)";
        int result = -1;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,teacher.getTeacher_name());
            ps.setString(2,teacher.getTeacher_code());
            ps.setString(3,teacher.getSex());
            ps.setString(4,teacher.getPhone());
            ps.setInt(4,teacher.getQq());
            ps.setString(5,teacher.getMail());
            ps.setString(6,teacher.getTips());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //---------------------------------------3、查找课程名-------------------------------------------------------
    //所用表:lesson
    public Lesson findLesson(){
        Connection conn = DbHelper.getConnction();
        String sql = "SELECT lesson_name from lesson";
        Lesson lesson = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                lesson.setLesson_name(resultSet.getNString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesson;
    }

    //---------------------------------------4、管理员修改教师信息------------------------------------------------
    //所用表：teacher
    public int updateTeacher(Teacher teacher,String code){
        Connection conn = DbHelper.getConnction();
        String sql = "UPDATE teacher set teacher_name = ?,teacher_code = ?, sex = ?,phone = ?,qq = ?,mail = ?,tips = ? where teacher_code = ?";
        int result = -1;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,teacher.getTeacher_name());
            ps.setString(2,teacher.getTeacher_code());
            ps.setString(3,teacher.getSex());
            ps.setString(4,teacher.getPhone());
            ps.setInt(5,teacher.getQq());
            ps.setString(6,teacher.getMail());
            ps.setString(7,teacher.getTips());
            ps.setString(8,code);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //---------------------------------------5、删除教师信息----------------------------------------------------
    //所用表：teacher
    public int deleteTeacher(String code){
        Connection conn = DbHelper.getConnction();
        String sql = "DELETE FROM teacher WHERE teacher_code = ?";
        int result = -1;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,code);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

//测试
//    public static void main(String[] args) {
//        ManageDao md = new ManageDao();
//        Student student = new Student();
//        Classes classes = new Classes();
//        int cont = 1;
//        List <XSLB> list =md.findAllStudent();
//        for (XSLB xslb:list) {
//            student = xslb.getStudent();
//            classes = xslb.getClasses();
//            System.out.print(cont+"    ");
//            System.out.print(student.getStudent_name()+"    ");
//            System.out.print(student.getStudent_code()+"    ");
//            System.out.print(student.getSex()+"    ");
//            System.out.print(classes.getClass_name()+"    ");
//            System.out.print(classes.getGrade_name()+"    ");
//            System.out.print(student.getPhone()+"    ");
//            System.out.print(student.getQq()+"    ");
//            System.out.print(student.getMail()+"    ");
//            System.out.println();
//            cont++;
//        }
//    }
}
