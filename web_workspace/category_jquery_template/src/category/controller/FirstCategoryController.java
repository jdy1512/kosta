package category.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.model.service.CategoryService;

import common.controller.AttributeAndView;
import common.controller.Controller;
/*
 * 대분류 조회 처리
 */
public class FirstCategoryController implements Controller {

	@Override
	public AttributeAndView handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		CategoryService cs = CategoryService.getInstance();
		AttributeAndView av = null;
		try {
			ArrayList list = cs.getAllFirstCategory();
			av = new AttributeAndView("/category_list.jsp", false, "firstCategory", list);
		} catch (SQLException e) {
			e.printStackTrace();
			av = new AttributeAndView("/error.jsp", false);
		}
		return av;
	}

}
