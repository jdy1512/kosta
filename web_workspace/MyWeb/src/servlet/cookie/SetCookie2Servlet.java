package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookie2Servlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 쿠키 생성 key : name - value : 홍길동
		PrintWriter out = resp.getWriter();
		
		Cookie cookie = new Cookie("name", URLEncoder.encode("홍길동", "utf-8"));
		
		// 쿠키 전송
		resp.addCookie(cookie);
		
		//getCookie, setCookie2 로 링크 응답
		out.println("<html><body>");
		out.println("<a href='/myweb/setCookie'>setCookie 요청</a><br/>");
		out.println("<a href='/myweb/getCookie'>쿠키값조회 - getCookie</a>");
		out.println("</body></html>");
	}
}