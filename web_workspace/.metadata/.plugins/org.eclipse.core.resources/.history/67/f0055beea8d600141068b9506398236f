<%@ page contentType="text/html; charset=UTF-8" %>
<%
// 쿠키값 설정
Cookie c1 = new Cookie("cookie_id", "cookie_id");
Cookie c2 = new Cookie("now", "2015.03.30");

//쿠키의 Max Age값 설정
c2.setMaxAge(60 * 60);

// 쿠키 전송 - 응답 헤더에 추가
response.addCookie(c1);
response.addCookie(c2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='el_response.jsp' method='post'>
		name : <input type='text' name='name'><br/>
		age : <input type = 'text' name = 'age' /><br/>
		취미 :
		영화감상 : <input type = 'checkbox' name = 'hobby' value = 'movie' />
		음악감상 : <input type = 'checkbox' name = 'hobby' value = 'music' />
		독서 : <input type = 'checkbox' name = 'hobby' value = 'reading' />
		<br/>
		<input type = 'submit' value = '전송' />
	</form>
</body>
</html>