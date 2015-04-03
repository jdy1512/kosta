<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${ param.id }로 조회한 결과<p/>
	결과 1 : ${ requestScope.result1 }<br/>
	결과 2 : ${ requestScope.result2 }
</body>
</html>