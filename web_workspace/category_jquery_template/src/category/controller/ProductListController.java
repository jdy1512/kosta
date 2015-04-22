package category.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AttributeAndView;
import common.controller.Controller;
import category.model.service.CategoryService;

/*
 * 제품 목록 조회처리(제품리스트)
 */
public class ProductListController implements Controller {

	@Override
	public AttributeAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String thirdCategoryId = request.getParameter("thirdCategoryId");
		CategoryService cs = CategoryService.getInstance();
		ArrayList list = cs.getProductInfoByCategoryId(thirdCategoryId);
		return new AttributeAndView("/jsonResponse", false, "res_data", list);
	}

}
