package servlet;

import bean.Adi;
import service.LoginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Created by lanqiao on 2017/5/24.
 */
@WebServlet(name="doLogin" ,urlPatterns="/doLogin")
public class doLogin extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID=1L;
    public doLogin(){
        super();
    }
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //response.setContentType("text/html;charset =UTF-8");
        String adi_name=request.getParameter("adi_name").trim();
        String adi_pwd=request.getParameter("adi_pwd").trim();


        Adi adi = new Adi(adi_name,adi_pwd);
        LoginService ls=new LoginService();
        Boolean flag=ls.findUserByUser(adi);


        if(flag){
            //response.sendRedirect("/Stu/StuM/admin.jsp");
            HttpSession session = request.getSession();
            session.setAttribute("adi",adi);
            response.sendRedirect("AdminServlet");
        }else{
            response.sendRedirect("/StuM/login.jsp");
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
