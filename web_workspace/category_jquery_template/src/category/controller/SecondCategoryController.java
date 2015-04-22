package category.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AttributeAndView;
import common.controller.Controller;
import category.model.service.CategoryService;
/*
 * 중분류 조회처리
 */
public class SecondCategoryController implements Controller {

	@Override
	public AttributeAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String firstCategoryId = request.getParameter("firstCategoryId");
		CategoryService cs = CategoryService.getInstance();
		
		ArrayList list = cs.getSecondCategory(firstCategoryId);
		
		return new AttributeAndView("/jsonResponse", false,"res_data", list);
	}

}
