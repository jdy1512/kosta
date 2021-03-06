<%@page import="servlet.vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- 
	//스크립트 태그를 이용한 기존 방법.
	Member member = (Member)request.getAttribute("member");
	if(member==null){
		member=new Member();
		request.setAttribute("member",member);
	}
--%>
	<jsp:useBean id="member" class="servlet.vo.Member" scope="request"/>
	<jsp:useBean id="sessionMember" class="servlet.vo.Member" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Response</title>
</head>
<body>
	Expression Tag 이용<br/>
	ID : <%=member.getId() %> <br/>
	Password : <%=member.getPassword() %>  <br/>
	이름 : <%=member.getName() %>  <br/>
	나이 : <%=member.getAge() %>  <br/>
	결혼 여부 : <%=member.isMarriage()==true?"기혼":"미혼"%>  <p/>

	setProperty 이후 getProperty 이용<br/>
	<jsp:setProperty property="id" name="member" value="id-00"/>
	<jsp:setProperty property="password" name="member"  value="1234"/>
	<jsp:setProperty property="name" name="member" value="김철수"/>
	<jsp:setProperty property="age" name="member" value="22"/>
	<jsp:setProperty property="marriage" name="member" value="false"/>
	
	ID : <jsp:getProperty property="id" name="member"/><br/>
	password : <jsp:getProperty property="password" name="member"/><br/>
	이름 :<jsp:getProperty property="name" name="member"/><br/>
	나이 : <jsp:getProperty property="age" name="member"/><br/>
	결혼여부 : <jsp:getProperty property="marriage" name="member"/><p/>
	
	<!-- Session scope의 session-member attribute의 속성 값들 출력 -->
	<h2>회원정보 - session</h2>
	ID : <%=sessionMember.getId() %> <br/>
	Password : <%=sessionMember.getPassword() %>  <br/>
	이름 : <%=sessionMember.getName() %>  <br/>
	나이 : <%=sessionMember.getAge() %>  <br/>
	결혼 여부 : <%=sessionMember.isMarriage()==true?"기혼":"미혼"%> 
	
</body>
</html>