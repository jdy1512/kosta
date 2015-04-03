<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>덧셈요청</legend>
		<form action="/calculaterMVC/plus" method="post">
			num1 : <input type="number" name="num1"><br/>
			num2 : <input type="number" name="num2"><br/>
			<input type="submit" value="덧셈">
		</form>
	</fieldset>
</body>
</html>