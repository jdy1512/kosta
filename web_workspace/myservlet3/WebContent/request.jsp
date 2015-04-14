<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>HelloWorldServlet호출</h2>
	<form action="/myservlet3/hello" method="post">
		이름 : <input type="text" name="name">
		<input type="submit" value="전송">
	</form>
	<hr/>
	
	<form action="/myservlet3/greet" method="post">
		이름 : <input type="text" name="name">
		<input type="submit" value="전송">
	</form>
</body>
</html>