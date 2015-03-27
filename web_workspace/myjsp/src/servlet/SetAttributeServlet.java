package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.vo.Member;

public class SetAttributeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
		//member 객체 생성.
		Member member = new Member("id-1","1111","홍길동",20,false);
		Member member2 = new Member("id-session","2222","임꺽정",30,false);
		Member member3 = new Member("id-3","3333","심봉사",80,true);
		//request scope binding
		request.setAttribute("member", member);
		
		HttpSession session = request.getSession();
		session.setAttribute("sessionMember", member2);
		
		//request dispatch로 response.jsp로 보냄.
		RequestDispatcher rd = request.getRequestDispatcher("/actiontag/response.jsp");
		rd.forward(request, response);
		
		
		
	}
}
