package servlet;

import bean.Adi;
import bean.Stu;
import service.FindStuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lanqiao on 2017/5/24.
 */
@WebServlet(name="AdminServlet" ,urlPatterns="/AdminServlet")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID=1L;

    FindStuService FSS = new FindStuService();

    public AdminServlet(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        if(session==null){
            response.sendRedirect("/StuM/login.jsp");
        }

        List list = FSS.FindSs();
        request.setAttribute("AAA",list);

        request.getRequestDispatcher("/StuM/admin.jsp").forward(request,response);
    }
}
