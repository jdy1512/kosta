package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookieServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 실행 시점의 일시를 쿠키로 전송
		PrintWriter out = resp.getWriter();
		
		Date date = new Date();
		String dateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
		// 쿠키값을 생성
		Cookie c = new Cookie("dateTime", dateTime);
		// 클라이언트에게 전송 - HTTP 응답 정보의 Header 추가
		resp.addCookie(c);
		
		out.println("<html><body>");
		out.println("<a href='/myweb/setCookie2'>set cookie2 요청</a><br/>");
		out.println("<a href='/myweb/getCookie'>쿠키값조회 - getcookie</a>");
		out.println("</body></html>");
	}
}
