package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 요청파라미터 조회
		String info = request.getParameter("info");
		
		// 비지니스 로직처리 - Model 호출
		System.out.println("RegisterController에서 Model을 호출해 BL 처리");
		System.out.println("등록 정보 : " + info);
		
		// 응답처리(FC에 응답할 곳(View)에 대한 정보를 전달)
		return new AttributeAndView(false, "/WEB-INF/view/response/response1.jsp");
	}

}
