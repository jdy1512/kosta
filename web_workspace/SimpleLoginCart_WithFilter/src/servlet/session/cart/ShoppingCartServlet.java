package servlet.session.cart;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. 로그인 체크
		HttpSession session = request.getSession();
		String url = null;
		boolean isRedirect = false;
		

		// 장바구니 처리
		// 요청파라미터 조회
		String [] items = request.getParameterValues("items");
		
		if(items==null){//상품을 선택하지 않고 요청한 경우.
			request.setAttribute("error_message", "상품을 한개 이상 선택하세요");
			url = "/WEB-INF/jsp/cart/list.jsp";
		} else {//장바구니 처리
			//상품들을 장바구니에 담는 작업
			// Session에서 Cart 조회||생성(없는 경우)
			HashMap<String, Integer> cart = (HashMap)session.getAttribute("cart");
			if(cart==null){
				cart = new HashMap<String, Integer>();
				session.setAttribute("cart", cart);
			}
			// Cart에 상품담기
			for(int i = 0; i<items.length; i++){
//				  Cart에 없는 상품인 경우 추가, 있는 상품인 경우 개수 증가
				if(cart.containsKey(items[i])){//있는 상품
					int cnt = cart.get(items[i])+1;
					cart.put(items[i], cnt);
				}else{//없는 상품
					cart.put(items[i], 1);
				}
			}	
			
//			url = "/WEB-INF/jsp/cart/show_cart.jsp";
			url = "/SimpleLoginCart_WithFilter/redirect?path=/WEB-INF/jsp/cart/show_cart.jsp";
			isRedirect = true;
		}//장바구니 처리 if문
		
//		응답
		if(isRedirect){//리다이렉트 방식 이동
			response.sendRedirect(url);
		}else{//요청 디스패치
			RequestDispatcher rdp = request.getRequestDispatcher(url);
			rdp.forward(request, response);
		}
		
	}
}


























