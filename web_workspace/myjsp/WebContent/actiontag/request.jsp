<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Request</title>
</head>
<body>
	<%@ include file='/include/menu.jsp' %>
	<a href="/myjsp/setAttribute">Set Attribute 요청</a>
	<form action='/myjsp/actiontag/response2.jsp'>
		ID : <input type='text' name='id'><br/>
		이름 : <input type='text' name='name'><br/>
		나이 : <input type='number' name='age'><br/>
		결혼여부 : <label><input type='radio' name='marriage', value='true'>기혼</label>
		<label><input type='radio' name='marriage' value='false'>미혼</label><br/>
		<input type='submit' value='전송'>
	</form>
</body>
</html>