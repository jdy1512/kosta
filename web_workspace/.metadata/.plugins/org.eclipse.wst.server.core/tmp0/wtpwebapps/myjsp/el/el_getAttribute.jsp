<%@page import="servlet.vo.Member"%>
<%@page import="servlet.vo.Address"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	request.setAttribute("name", "김영수");
	request.setAttribute("age", 20);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : ${ requestScope.name }<br/>
	이름 (session) : ${ sessionScope.name } - session.getAttribute("name")<br/>
	나이 : ${ requestScope.age }
	<hr/>
	<%
		Address addr = new Address("addr-id", "222-333", "경기도 성남시 분당구 삼평동");
		Member member = new Member("id-1", "1111", "김회원", 20, false, addr);
		request.setAttribute("member", member);
	%>
	<h2>조회한 회원 정보</h2>
	ID : ${ requestScope.member.id }<br/>
	패스워드 : ${ requestScope.member.password }<br/>
	이름 : ${ requestScope.member.name }<br/>
	나이 : ${ requestScope.member.age }<br/>
	결혼여부 : ${ requestScope.member.marriage }<br/>
	주소 ID : ${ requestScope.member.address.id }<br/>
	우편번호 : ${ requestScope.member.address.zipcode }<br/>
	나머지 주소 : ${ requestScope.member.address.addr }<br/>
</body>
</html>