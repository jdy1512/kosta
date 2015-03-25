<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String message = (String)request.getAttribute("failMessage") ;
%>
<!-- id/password 이름으로 요청파라미터를 전송하는 form을 작성. - session_login으로 요청 -->
<h2>로그인폼</h2>
<%if(message != null){ %>
	<font color="red"><%=message%></font>
<%} %>
<form action="/SimpleLoginCart_WithFilter/session_login" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="로그인"></td>
		</tr>
	</table>
</form>
</body>
</html>

