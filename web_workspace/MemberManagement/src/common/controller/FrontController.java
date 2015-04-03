package common.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.util.HandlerMapping;
import common.vo.AttributeAndView;
public class FrontController extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공통적 선처리 작업 
		request.setCharacterEncoding("UTF-8");
		
		try {
			AttributeAndView av = HandlerMapping.getController(request.getParameter("command"), request, response);
			
			// 공통적 후처리 작업 - 응답처리 ( redirect, RequestDispatch- request scope 속성을 binding)
			if (av.isRedirect()) {
				response.sendRedirect(av.getUrl());
			} else {
				// 만약에 av에 attribute가 있다면 requestScope에 binding
				Map<String, Object> attributes = av.getAttributes();
				if (attributes != null && attributes.size() != 0) {
					Set<String> keys = attributes.keySet();
					for (String attrName : keys) {
						Object value = attributes.get(attrName);
						request.setAttribute(attrName, value);
					}
				}

				RequestDispatcher rd = request.getRequestDispatcher(av.getUrl());
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("errorMessage", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/error.jsp");
			rd.forward(request, response);
		}
	}
}
