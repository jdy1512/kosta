package servlet.session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionLoginServlet extends HttpServlet {
	private Map<String, String> userInfo;// id, password
	
	@Override
	public void init() throws ServletException {
		userInfo = new HashMap<String, String>();
		userInfo.put("id-1", "1111");
		userInfo.put("id-2", "2222");
		userInfo.put("id-3", "3333");
		userInfo.put("id-4", "4444");
		userInfo.put("id-5", "5555");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 요청 파라미터 조회
		req.setCharacterEncoding("UTF-8");
		String requestUserId = req.getParameter("id");
		String requestUserPassword = req.getParameter("password");
		
		HttpSession session = req.getSession();
		
		// 비지니스로직처리 - 로그인 처리(id체크/password체크 따로)
		String failMessage = null;// 로그인 실패의 경우 실패 이유 저장할 변수.
		if (userInfo.containsKey(requestUserId)) {// id비교-성공
			if (userInfo.get(requestUserId).equals(requestUserPassword)) {// password비교-성공
				session.setAttribute("loginInfo", requestUserId);
//				req.setAttribute("result", requestUserId + "님 로그인 성공");
			} else {// password 틀린 경우
				failMessage = "Password가 틀립니다.";
			}
		} else {// id 없는 경우
			failMessage = "ID가 없습니다.";
		}
		
		// 처리결과 응답
		RequestDispatcher rdp = null;
		
		if (failMessage != null) {
			req.setAttribute("failMessage", failMessage);
			rdp = req.getRequestDispatcher("/session/login_form.jsp");
		} else {
			rdp = req.getRequestDispatcher("/session/login_success.jsp");
		}
		rdp.forward(req, resp);
	}
}
