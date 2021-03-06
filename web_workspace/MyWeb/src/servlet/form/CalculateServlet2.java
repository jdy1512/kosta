package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet2 extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NumberFormatException {
		
		req.setCharacterEncoding("UTF-8");
		double x = Double.parseDouble(req.getParameter("xValue"));
		double y = Double.parseDouble(req.getParameter("yValue"));
		char operator = req.getParameter("operator").charAt(0);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String result = null;
		
		switch (operator) {
		case '+':
			result = x + " + " + y + " = " + (x + y);
			break;
		case '-':
			result = x + " - " + y + " = " + (x - y);
			break;
		case 'x':
			result = x + " x " + y + " = " + new DecimalFormat(".##").format(x * y);
			break;
		case '/':
			if (y == 0) result = x + " / " + y + " = 0";
			else result = x + " / " + y + " = " + new DecimalFormat(".##").format(x / y);
			break;
		}
		
		req.setAttribute("result_message", result);
		RequestDispatcher rdp = req.getRequestDispatcher("/WEB-INF/jsp/calculate_result.jsp");
		rdp.forward(req, resp);
	}
}
