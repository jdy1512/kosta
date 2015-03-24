<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%
	Map<String, Integer> shoppingCartMap = (Map<String, Integer>) session.getAttribute("shoppingCartMap");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" role="none">
		<tr>
			<td rowspan="2">
				<fieldset>
					<legend>장바구니</legend>
					<% for (Entry<String, Integer> entry : shoppingCartMap.entrySet()) { %>
						<%= entry.getKey().toString() %>
						&nbsp;
						<%= entry.getValue().toString() %>
						<br/>
					<% } %>
				</fieldset>
			</td>
			
			<td>
				<a href="/myweb/shoppingList">쇼핑계속</a>
			</td>
		</tr>
		
		<tr>
			<td>
				계산
			</td>
		</tr>
	</table>
</body>
</html>