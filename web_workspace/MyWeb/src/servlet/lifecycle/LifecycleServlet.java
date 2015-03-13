package servlet.lifecycle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifecycleServlet extends HttpServlet {
	
	public LifecycleServlet() {
		System.out.println("LifecycleServlet.생성자() 호출");
	}
	
	public void init() {
		System.out.println("LifecycleServlet.init() 호출");
	}
	
	public void destroy() {
		System.out.println("LifecycleServlet.destroy() 호출");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("LifecycleServlet.doGet() 호출");
	}
}
