package servlet.dispatch;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicDispatchTestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 요청 파라미터 page 값을 조회
		req.setCharacterEncoding("UTF-8");
		String page = req.getParameter("page");
		
		// page=one : one.html, page=two : two.jsp 로 요청 디스패치 방식으로 수행을 이동
		String url = null;
		if (page.equals("one")) {
			url = "/dispatch/one.html";
		} else if (page.equals("two")) {
			url = "/dispatch/two.jsp";
			req.setAttribute("message", "이것은 서블릿에서 설정한 메세지입니다.");
			req.setAttribute("time", new Date());
		}
		// 요청 디스패치 방식으로 이동 처리
		// 1. RequestDispatcher 객체 조회
		RequestDispatcher rdp = req.getRequestDispatcher(url);
		// 2. 이동
		rdp.forward(req, resp);
	}
}
