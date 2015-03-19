<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String resultMessage = (String) request.getAttribute("resultMessage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= resultMessage %>
</body>
</html>