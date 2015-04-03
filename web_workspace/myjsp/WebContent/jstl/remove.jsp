<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <remove> : 속성을 제거 - scope(속성영역), var(속성명) - removeAttribute() -->
	세션 에러메세지 : ${ sessionScope.sessionError }<br/>
	<c:remove scope="session" var="sessionError"/>
	<!-- session.removeAttribute("sessionError"); -->
	세션 에러메세지 : ${ sessionScope.sessionError }<br/>
</body>
</html>