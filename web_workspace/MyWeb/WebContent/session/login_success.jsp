<%@ page contentType="text/html; charset=UTF-8" %>
<%
	// JSP에서 HttpSession객체 사용시 - request.getSession()하지 않고 그냥 session이라는 변수를 사용.
	String loginId = (String) session.getAttribute("login_info");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/myweb/logout">로그아웃</a>
	&nbsp;&nbsp;
	<a href="/myweb/shoppingList">상품목록</a>
</body>
</html>