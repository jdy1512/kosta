package jquery.service;

import java.util.ArrayList;

import jquery.vo.Member;


public class MemberService {

	public Member getMemberById(String id){
		return new Member(id, "홍길동", 30);
	}
	public ArrayList<String> getAllIds(){
		ArrayList<String> ids = new ArrayList<String>();
		ids.add("aaaa");
		ids.add("bbbb");
		ids.add("cccc");
		ids.add("dddd");
		ids.add("eeee");
		return ids;
		
	}
}
