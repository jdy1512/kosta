package category.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AttributeAndView;
import common.controller.Controller;
import category.model.service.CategoryService;

/*
 * 소분류 조회처리
 */
public class ThirdCategoryController implements Controller {

	@Override
	public AttributeAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String secondCategoryId = request.getParameter("secondCategoryId");
		CategoryService cs = CategoryService.getInstance();
		ArrayList list = cs.getThirdCategory(secondCategoryId);
		return new AttributeAndView("/jsonResponse", false, "res_data", list);
	}

}
