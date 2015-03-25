package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//요청파라미터로 받은 경로로 요청디스패치 방식으로 수행을 이동처리.
		String path = request.getParameter("path");
		RequestDispatcher rdp = request.getRequestDispatcher(path);
		rdp.forward(request, response);
	}
}



























