package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		// 클라이언트(웹브라우저)가 HTTP 요청정보의 Header를 이용해 전송한 쿠키값들 조회
		Cookie[] cookies = req.getCookies();
		if (cookies == null) {
			out.println("전송된 쿠키값이 하나도 없습니다.");
			return;
		}
		for (int idx = 0; idx < cookies.length; idx++) {
			String name = cookies[idx].getName();
			String value = cookies[idx].getValue();
			if (name.equals("name")) {
				value = URLDecoder.decode(value, "utf-8");
			}
			System.out.println(name + ", " + value);
		}
	}
}