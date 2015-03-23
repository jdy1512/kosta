package servlet.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionLogoutServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 요청한 클라이언트의 로그아웃 처리
		// 로그인 여부를 체크
		// 1.HttpSession객체 조회
		HttpSession session = req.getSession();
		// 2.로그인 여부체크
		Object loginInfo = session.getAttribute("loginInfo");
		
		if (loginInfo == null) {// 로그인 안했다.
			req.setAttribute("failMessage", "로그인 먼저 하세요.");
		} else {// 로그인 한 클라이언트
			// 로그아웃 처리
			session.invalidate();
		}
		// 응답
		RequestDispatcher rdp = req.getRequestDispatcher("/session/login_form.jsp");
		rdp.forward(req, resp);
	}
}
