package servlet;

import bean.Stu;
import service.AddStuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lanqiao on 2017/5/25.
 */
@WebServlet(name = "AddServlet" ,urlPatterns="/AddServlet")
public class AddServlet extends HttpServlet {
    int back=0;
    AddStuService ass = new AddStuService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String stu_name = request.getParameter("stu_name");
        String stu_pwd = request.getParameter("stu_pwd");
        String stu_status= request.getParameter("stu_status");


        System.out.println("-----------");
        System.out.println(stu_name);
        System.out.println(stu_pwd);
        System.out.println(stu_status);
        System.out.println("-----------");
        //System.out.println(stu_name+stu_pwd+stu_status);

        Stu stu = new Stu(stu_name,stu_pwd,stu_status);

        back=ass.addSs(stu);


        String backt="添加失败";

        if(back>0){backt="添加成功";}

        request.setAttribute("backt",backt);
        request.getRequestDispatcher("/StuM/admin.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
