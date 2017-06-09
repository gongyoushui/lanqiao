package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lanqiao on 2017/5/24.
 */
@WebServlet(name="NormalServlet",urlPatterns="/NormalServlet")
public class NormalServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    public NormalServlet(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("name");
        if(name==null){
            response.sendRedirect("login.jsp");
        }
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<head><title>显示结果界面</title></head>");
        out.print("<body>");
        out.print("您好，这是普通用户内容页，您是："+name+"，欢迎！");
        out.print("</body>");
        out.print("</html>");
        out.close();
    }
}
