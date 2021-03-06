package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setHeader("cache-control", "no-cache,no-store");
		PrintWriter out = resp.getWriter();
		
		String cmd = req.getParameter("cmd");
		
		if (cmd.equals("get_hello")) {
			String name = req.getParameter("name");
			System.out.println(name);
			
			// 업무로직처리
			String greeting = name + "님! 안녕하세요.. 반갑습니다.";
			
			// 응답
			out.print(greeting);
		} else if (cmd.equals("plus")) {
			out.print(plus(req, resp));
		} else if (cmd.equals("idcheck")) {
			out.print(idcheck(req, resp));
		}
	}
	
	private int plus(HttpServletRequest req, HttpServletResponse resp) {
		int op1 = Integer.parseInt(req.getParameter("operand1"));
		int op2 = Integer.parseInt(req.getParameter("operand2"));
		return op1 + op2;
	}
	
	private String idcheck(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<String> id = new ArrayList<String>();
		id.add("abcdef");
		id.add("abcdefg");
		id.add("abcdefghi");
		id.add("abcdefghij");
		id.add("111111");
		id.add("11111111");
		id.add("111111111");
		id.add("1111111111");
		id.add("aaaaaa");
		id.add("aaaaaaa");
		id.add("aaaaaaaa");
		id.add("aaaaaaaaaa");
		
		String resultStr = null;
		String userId = req.getParameter("id");
		if (id.contains(userId)) {
			resultStr = "<font color='red'>" + userId + "는 이미 등록된 ID입니다.</font>";
		} else {
			resultStr = "<font color='blue'>사용 가능</font>";
		}
		return resultStr;
	}
}
