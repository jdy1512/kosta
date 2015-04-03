package member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.vo.Member;

import common.controller.Controller;
import common.vo.AttributeAndView;

public class MemberListController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<Member> memberList = MemberService.getInstance().getMemberList();
		
		return new AttributeAndView(false, "/WEB-INF/member/member_list.jsp", "memberList", memberList);
	}

}
