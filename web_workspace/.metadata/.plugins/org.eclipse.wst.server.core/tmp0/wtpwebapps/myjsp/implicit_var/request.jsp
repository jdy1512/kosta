<%@ page contentType="text/html;charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Request</title>
</head>
<body>
	<form action="response.jsp" method="post">
	<table style="text-align: center">
	<tr>
		<td>ID  </td>
		<td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>Password  </td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td>이름  </td>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Request" style="background-color: silver"><td>
	</tr>
	</table>
</form>
<hr/>
회사명 : <%=application.getInitParameter("company name") %><br/>
주소 : <%=application.getInitParameter("address") %><br/>
전화번호 : <%=application.getInitParameter("tel") %>
</body>
</html>