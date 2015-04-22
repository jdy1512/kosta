package jquery.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jquery.service.MemberService;
import jquery.vo.Member;

import org.json.JSONObject;


@WebServlet("/jQueryCtr")
public class JQueryController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("command");
		System.out.println(cmd);
		if(cmd.equals("getData")){
			getData(request, response);
		}else if(cmd.equals("getMemberById")){
			getMemberById(request, response);
		}else if(cmd.equals("getMemberByIdJson")){
			getMemberByIdJson(request, response);
		}else if(cmd.equals("register")){
			register(request, response);
		}
	}
	protected void getData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter out = response.getWriter();
		out.print("<b>이것이 답입니다.</b><br>요청방식 : "+request.getMethod());
	}
	protected void getMemberById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요처파라미터 조회
		String id = request.getParameter("id");
		//2. B.L. 호출
		MemberService ms = new MemberService();
		Member member = ms.getMemberById(id);
		//3. 응답
		String str = "id : "+member.getId()+"<br>이름 : "+member.getName()+"<br>나이 : "+member.getAge();
		
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter out = response.getWriter();
		out.print(str);
	}
	protected void getMemberByIdJson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요처파라미터 조회
		String id = request.getParameter("id");
		//2. B.L. 호출
		MemberService ms = new MemberService();
		Member member = ms.getMemberById(id);
		//3. 응답
		//JSONObject - JSON 객체 형태의 문자열(string)생성
		JSONObject jObj = new JSONObject(member);
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter out = response.getWriter();
		out.print(jObj.toString());
	}
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name=request.getParameter("name");
		String isSend = request.getParameter("isSend");
		String number = request.getParameter("number");
		String str = id+", "+name+", "+isSend+", "+number;
		System.out.println(str);
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("cache-control", "no-cache,no-store");
		PrintWriter out = response.getWriter();
		out.print(str);
	}
	

}
