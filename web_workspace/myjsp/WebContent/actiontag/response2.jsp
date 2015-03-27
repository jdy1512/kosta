<%@page import="servlet.vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
	<jsp:useBean id="member" class="servlet.vo.Member" scope="page"/>
	<!-- jsp:setProperty name='member' property='name' value='이철수'/ -->
	<jsp:setProperty name='member' property='*'/>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보-response2.jsp</h2>
	ID : <%=member.getId() %> <br/>
	이름 : <%=member.getName() %>  <br/>
	나이 : <%=member.getAge() %>  <br/>
	결혼 여부 : <%=member.isMarriage()==true?"기혼":"미혼"%><br/>
	
	<!-- 요청파라미터로 받은 값을 session scope의 member2 Attribute객체의 property에 넣으세요. -->
	<h2>Session의 회원 정보</h2>
	<jsp:useBean id="member2" class="servlet.vo.Member" scope="session"/>
	<jsp:setProperty name='member2' property='*'/>
	
	ID : <%=member2.getId() %> <br/>
	Password : <%=member2.getPassword() %>  <br/>
	이름 : <%=member2.getName() %>  <br/>
	나이 : <%=member2.getAge() %>  <br/>
	결혼 여부 : <%=member2.isMarriage()==true?"기혼":"미혼"%><br/>
	
	<a href='/myjsp/actiontag/request.jsp'>요청페이지</a>
</body>
</html>