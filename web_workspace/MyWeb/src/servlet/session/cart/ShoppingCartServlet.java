package servlet.session.cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCartServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1.로그인 체크 x -> login_form.jsp 이동
		HttpSession session = req.getSession();
		Object loginInfo = session.getAttribute("loginInfo");
		
		if (loginInfo == null) {
			req.setAttribute("failMessage", "로그인 먼저 하세요.");
		}
		
		// 2.장바구니 처리 -> 요청파라미터 조회 (전송된 상품x 인경우 체크) - 장바구니에 상품 담기
		req.setCharacterEncoding("UTF-8");
		String[] selectedList = req.getParameterValues("product");
		String url = null;
		boolean isRedirect = false;
		
		if (selectedList == null) {
			req.setAttribute("failMessage", "상품을 선택하세요.");
			url = "/WEB-INF/jsp/cart/list.jsp";
		} else {
			Map<String, Integer> shoppingCartMap = (Map<String, Integer>) session.getAttribute("shoppingCartMap");
			if (shoppingCartMap == null) {
				shoppingCartMap = new HashMap<String, Integer>();
			}
			
			for (int i = 0; i < selectedList.length; i++) {
				int value = 0;
				if (shoppingCartMap.containsKey(selectedList[i])) {
					value = shoppingCartMap.get(selectedList[i]);
				}
				shoppingCartMap.put(selectedList[i], value + 1);
			}
			
			session.setAttribute("shoppingCartMap", shoppingCartMap);

//			url = "/WEB-INF/jsp/cart/show_cart.jsp";
			url = "/myweb/redirect?path=/WEB-INF/jsp/cart/show_cart.jsp";
			isRedirect = true;
		}
		
		// 응답
		if (isRedirect) {
			resp.sendRedirect(url);
		} else {
			RequestDispatcher rdp = req.getRequestDispatcher(url);
			rdp.forward(req, resp);
		}
	}
}
