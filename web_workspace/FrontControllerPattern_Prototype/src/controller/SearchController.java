package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");

		System.out.println("SearchController에서 Model 호출하여 BL 처리");// 있는지 없는지 확인.
		System.out.println("조회 ID : " + id);
		String result1 = "조회결과1";
		String result2 = "조회결과2";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result1", result1);
		map.put("result2", result2);

		return new AttributeAndView(false, "/WEB-INF/view/response/response2.jsp", map);
	}

}
