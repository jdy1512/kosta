package servlet.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	String dbId = "java";
	String dbPwd = "servlet";

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 파라미터 id/password를 조회
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		boolean flag = false;// 로그인 성공여부를 저장할 변수
		String failMessage = null;// 로그인 실패시 그 이유를 저장할 변수
		// 로그인 처리
		if (id.equals(dbId)) {// ID가 맞다.
			if (password.equals(dbPwd)) {// ID & Password 맞다. - 로그인 성공
				flag = true;
			} else {// Password가 틀려서 실패
				failMessage = "패스워드를 다시 확인하세요";
			}
		} else {// 없는 ID
			failMessage = "없는 ID입니다.";
		}
		// 로그인 결과를 응답 (출력)
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		if (flag) {// 성공
			out.println(id + "님 로그인 성공했습니다.");
		} else {// 실패
			req.setAttribute("fail_message", failMessage);
			RequestDispatcher rdp = req.getRequestDispatcher("/form/login_fail.jsp");
			rdp.forward(req, resp);
//			out.println(failMessage + "<br/>");
//			out.println("<a href='/myweb/form/login_form.html'>로그인폼</a>");
		}
		
		out.println("</body></html>");
	}
}
