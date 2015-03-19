package servlet.initparam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingServlet extends HttpServlet{
   
   public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
      doGet(request,response);
   }
   public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
      // 초기 파라미터
      ServletConfig config= getServletConfig();
      String greeting = config.getInitParameter("greeting");
      String email = getInitParameter("email");
      
      request.setCharacterEncoding("UTF-8");
      String name = request.getParameter("name");
      
      // 응답
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();
      out.println("<html><body>");
      out.printf("인사말 : %s님, %s<br/>이메일 주소 : %s<br/>", name, greeting, email);
      out.println("</body></html>");
   }
}