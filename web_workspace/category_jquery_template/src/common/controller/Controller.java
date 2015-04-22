package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public AttributeAndView handle(HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
}
