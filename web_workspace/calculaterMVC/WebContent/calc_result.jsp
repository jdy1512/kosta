<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	계산 결과 : ${ requestScope.result }
	<p/>
	<a href="/calculaterMVC/request_plus.jsp">덧셈요청</a>
	<a href="/calculaterMVC/request_minus.jsp">뺄셈요청</a>
</body>
</html>