package servlet;

/**
 * Created by lanqiao on 2017/5/31.
 */
import bean.Stu;
import service.UpdateStuService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UpdateServlet extends HttpServlet{
    int back2=0;
    UpdateStuService uss = new UpdateStuService();
    protected void dopost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String stu_name=request.getParameter("stu_name");
        String stu_pwd=request.getParameter("stu_pwd");
        String stu_status=request.getParameter("stu_status");

        System.out.println("----------");
        System.out.println(stu_name);
        System.out.println(stu_pwd);
        System.out.println(stu_status);
        System.out.println("----------");

        Stu stu = new Stu(stu_name,stu_pwd,stu_status);

        back2=uss.upSs(stu);
        String backs="更新失败";
        if(back2>0){
            backs="更新成功";
        }

        request.setAttribute("backs",backs);
        request.getRequestDispatcher("/StuM/amdin.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        doPost(request,response);
    }
}
