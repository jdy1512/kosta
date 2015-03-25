package servlet.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청한 클라이언트의 로그아웃 처리
		
		// HttpSession객체 조회
		HttpSession session = request.getSession();
		
		// 로그아웃 처리
		session.invalidate();
		
		// 응답
		RequestDispatcher rdp = request.getRequestDispatcher("/session/login_form.jsp");
		rdp.forward(request, response);
	}
}


















