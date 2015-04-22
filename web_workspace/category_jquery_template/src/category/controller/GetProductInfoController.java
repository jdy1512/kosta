package category.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.model.service.CategoryService;
import category.vo.Product;
import common.controller.AttributeAndView;
import common.controller.Controller;

/*
 * 제품 ID로 하나의 제품 조회 처리
 */
public class GetProductInfoController implements Controller {

	@Override
	public AttributeAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String productId = request.getParameter("productId");
		CategoryService cs = CategoryService.getInstance();
		Product p = cs.getProductInfoById(productId);
		return new AttributeAndView("/jsonResponse", false, "res_data", p);
	}

}
