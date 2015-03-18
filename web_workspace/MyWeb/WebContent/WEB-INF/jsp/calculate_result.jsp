<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String result = (String) request.getAttribute("result_message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= result %><br/>
	<a href='/myweb/form/calculate_form.html'>다시 계산하기</a>
</body>
</html>