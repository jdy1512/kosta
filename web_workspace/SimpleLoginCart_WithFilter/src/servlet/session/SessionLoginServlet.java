package servlet.session;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionLoginServlet extends HttpServlet{
	private HashMap<String, String> userInfo;//id, password
	public void init(){
		userInfo = new HashMap<String, String>();
		userInfo.put("id-1", "1111");
		userInfo.put("id-2", "2222");
		userInfo.put("id-3", "3333");
		userInfo.put("id-4", "4444");
		userInfo.put("id-5", "5555");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//요청파라미터 조회
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		//비지니스로직처리 - 로그인 처리(id체크/password체크 따로)
		String failMessage = null;//로그인 실패의 경우 실패 이유 저장할 변수.
		if(userInfo.containsKey(id)){//id비교-성공
			if(userInfo.get(id).equals(password)){//password 비교 
//				-로그인성공:로그인한 클라이언트의 상태(정보)를 유지하겠다. 
				HttpSession session = request.getSession();//session scope를 생성
//				로그인 여부를 체크할 때 사용할 attribute를 session scope에 binding.
				session.setAttribute("login_info", id);			
				
//				System.out.println(session.isNew());
				
			}else{//password 틀린 경우
				failMessage = "패스워드를 확인하세요";
			}
		}else{//id 없는 경우
			failMessage = "아이디를 확인하세요";
		}
		//처리결과 응답
		if(failMessage != null){//실패
			request.setAttribute("failMessage", failMessage);
			RequestDispatcher rdp = request.getRequestDispatcher("/session/login_form.jsp");
			rdp.forward(request, response);
		}else{//성공
			response.sendRedirect("/SimpleLoginCart_WithFilter/session/login_success.jsp");
		}
	}
}









































