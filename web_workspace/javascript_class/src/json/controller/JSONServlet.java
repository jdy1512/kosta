package json.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import json.vo.Member;

@WebServlet("/json")
public class JSONServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd = req.getParameter("cmd");
		
		if (cmd.equals("searchMemberById")) {
			searchMemberById(req, resp);
		} else if (cmd.equals("subwayLine")) {
			subwayLine(req, resp);
		} else if (cmd.equals("getMemberList")) {
			getMemberList(req, resp);
		}
		
	}

	private void getMemberList(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int idx = (int) (Math.random() * 10 + 1);
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("id-" + (idx++), "김철수", "kim@a.com", 1000 * (idx + 1), false));
		list.add(new Member("id-" + (idx++), "이철수", "lee@a.com", 2000 * (idx + 1), false));
		list.add(new Member("id-" + (idx++), "박철수", "park@a.com", 3000 * (idx + 1), false));
		list.add(new Member("id-" + (idx++), "정철수", "jung@a.com", 4000 * (idx + 1), false));
		list.add(new Member("id-" + (idx), "안철수", "ann@a.com", 5000 * (idx + 1), false));
		
		resp.setContentType("text/html;charset=utf-8");
		JSONArray jArray = new JSONArray(list);
		PrintWriter out = resp.getWriter();
		out.print(jArray);
	}

	private void subwayLine(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String city = req.getParameter("city");
		ArrayList<String> lines = new ArrayList<String>();
		
		if(city.equals("seoul")){
			lines.add("1호선");
			lines.add("2호선");
			lines.add("3호선");
			lines.add("4호선");
			lines.add("5호선");
			lines.add("6호선");
			lines.add("7호선");
			lines.add("8호선");
			lines.add("9호선");
			lines.add("분당선");
			lines.add("신분당선");
		}else if(city.equals("busan")){
			lines.add("1호선");
			lines.add("2호선");
			lines.add("3호선");
			lines.add("4호선");
		}else if(city.equals("kwangju")){
			lines.add("1호선");
		}else if(city.equals("daegu")){
			lines.add("1호선");
			lines.add("2호선");
		}
		JSONArray jArray = new JSONArray(lines);
		
		// 응답처리
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(jArray);
	}

	private void searchMemberById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 요청 파라미터 조회
		String id = req.getParameter("id");
		// 비지니스 로직 처리 - Model을 호출
		Member result = new Member(id, "김철수", "kim@abc.com", 23000, false);
		// 응답처리
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		JSONObject obj = new JSONObject(result);
		out.print(obj);
	}
	
	
}
