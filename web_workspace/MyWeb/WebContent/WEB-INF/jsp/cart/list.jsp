<%@ page contentType="text/html; charset=UTF-8" %>
<%
	String failMessage = (String) request.getAttribute("failMessage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/myweb/shoppingCart" method="post">
		<% if (failMessage != null) { %>
		<font color="red"><%= failMessage %></font>
		<% } %>
		<fieldset style="width:10%;background-color:#e0ffd0">
			<legend>상품 목록</legend>
			<% String[] str = {"CPU","RAM","메인보드","VGA", "SSD","HDD","ODD","케이스","파워","모니터","키보드","마우스","노트북"};
			for (int i = 0; i < str.length; i++) { %>
			<label><input type="checkbox" name="product" value=<%= str[i] %>><%= str[i] %></label><br/>
			<% } %>
			<input type="submit" value="장바구니 담기" style="background-color: #B2CCFF"><br/>
		</fieldset>
	</form>
</body>
</html>