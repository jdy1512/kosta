<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	request.setAttribute("age", 33);
	String ageStr = null;
	%>
	<!-- 
		request속성의 age가 10 이하면 어린이, 10~20 이면 청소년, 20이상이면 성인 이라고 출력
	 -->
	<c:choose>
		<c:when test="${ requestScope.age <= 10 }"><% ageStr = "어린이"; %></c:when>
		<c:when test="${ requestScope.age <= 20 }"><% ageStr = "청소년"; %></c:when>
		<c:otherwise><% ageStr = "성인"; %></c:otherwise>
	</c:choose>
	당신의 나이는 ${ requestScope.age }세 이므로 당신은 '<%= ageStr %>'입니다.
	<br/>
	<hr/>
	<%
	session.setAttribute("login_info", "aa");
	%>
	<!-- 
	로그인 안한 경우 : 로그인, 회원가입, 고객센터
	로그인 한 경우 : 로그아웃, 마이페이지, 회원탈퇴, 고객센터
	 -->
	<c:choose>
		<c:when test="${ not empty sessionScope.login_info }">
			로그아웃, 마이페이지, 회원탈퇴, 고객센터
		</c:when>
		<c:otherwise>
			로그인, 회원가입, 고객센터
		</c:otherwise>
	</c:choose>
</body>
</html>