package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculateServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, NumberFormatException {
		
		req.setCharacterEncoding("UTF-8");
		double x = Double.parseDouble(req.getParameter("xValue"));
		double y = Double.parseDouble(req.getParameter("yValue"));
		char operator = req.getParameter("operator").charAt(0);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		switch (operator) {
		case '+':
			out.println(x + " + " + y + " = " + (x + y));
			break;
		case '-':
			out.println(x + " - " + y + " = " + (x - y));
			break;
		case 'x':
			out.println(x + " x " + y + " = " + new DecimalFormat(".##").format(x * y));
			break;
		case '/':
			if (y == 0) out.println(x + " / " + y + " = 0");
			else out.println(x + " / " + y + " = " + new DecimalFormat(".##").format(x / y));
			break;
		}
		out.println("<br/><a href='/myweb/form/calculate_form.html'>다시 계산하기</a>");
	}
}
