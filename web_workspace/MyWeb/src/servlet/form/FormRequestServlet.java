package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormRequestServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글 처리
		req.setCharacterEncoding("UTF-8");
		// 요청 파라미터 값 조회
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String sex = req.getParameter("sex");
		String[] langs = req.getParameterValues("language");
		String mailing = req.getParameter("mailing");
		String command = req.getParameter("command");
		String picture = req.getParameter("picture");
		String phone1 = req.getParameter("phone1");
		String introduction = req.getParameter("introduction");
		
		// client에게 처리 결과 응답
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h2>다음은 가입한 정보입니다.</h2>");
		out.println("이름 : " + name + "<br/>");
		out.printf("패스워드 : %s <br/>", password);
		out.printf("나이 : %s <br/>", age);
		out.printf("이메일 : %s <br/> 성별 : %s <br/> 히든값 : %s <br/>", email, sex, command);
		out.printf("전화번호 : %s <br/> 자기소개 %s <br/>", phone1, introduction);
		out.println("관심있는 언어");
		for (int i = 0; i < langs.length; i++) {
			out.print(langs[i] + ", ");
		}
	}
}
