package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

import common.controller.Controller;
import common.vo.AttributeAndView;

public class RemoveMemberController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = (String) request.getSession().getAttribute("login_info");
		
		MemberService.getInstance().removeMemberById(id);
		
		
		return new AttributeAndView(true, "/MemberManagement/controller?command=logout");
	}

}
