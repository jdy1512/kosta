<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	// java코드 - request scope에서 message와 time 이름으로 binding된 attribute 조회
	Object message = request.getAttribute("message");
	Date time = (Date) request.getAttribute("time");
	String currentTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
two.jsp입니다.<br/>
<%= message %><br/>
<%= currentTime %><br/>
<a href="/myweb/dispatch/request.html">
	Dispatch 요청 페이지(dispatch/request.html)로 이동
</a>
</body>
</html>