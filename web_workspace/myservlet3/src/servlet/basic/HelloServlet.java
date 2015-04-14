package servlet.basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// <servlet> : 서블릿 객체 등록. <servlet-mapping> : 요청URL과 연결. → @WebServlet

// @WebServlet("/hello") - URL pattern만 지정할 경우
// @WebServlet({ "/hello", "/greet" })
@WebServlet(urlPatterns = { "/hello", "/greet" },
			initParams = { @WebInitParam(name = "greeting", value = "안녕"), @WebInitParam(name = "greeting2", value = "안녕하세요.")},
			loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
	
	@Override
	public void init() {
		System.out.println("HelloServlet 객체 생성...");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String name = req.getParameter("name");
		String str = getInitParameter("greeting") + name + "님";

		req.setAttribute("greeting", str);
		RequestDispatcher rdp = req.getRequestDispatcher("/response.jsp");
		rdp.forward(req, resp);

	}
}
