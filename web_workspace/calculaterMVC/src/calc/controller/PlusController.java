package calc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calc.model.CalculateService;

public class PlusController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1.요청파라미터 조회, 검증
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		// 2.덧셈 처리 - business logic
		int result = CalculateService.getInstance().plus(num1, num2);
		
		// 3.응답 처리
		req.setAttribute("result", result);// jsp로 전달할 값을 request scope에 binding
		RequestDispatcher rdp = req.getRequestDispatcher("/calc_result.jsp");
		rdp.forward(req, resp);
	}
}
