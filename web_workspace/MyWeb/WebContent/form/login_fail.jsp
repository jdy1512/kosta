<%@ page contentType="text/html; charset=UTF-8" %>
<%
	// request scope의 fail_message 값(attribute)조회
	String failMessage = (String) request.getAttribute("fail_message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인 실패 : 이유 - <%= failMessage %> <br/>
	<a href="/myweb/form/login_form.html">로그인 폼</a>
</body>
</html>