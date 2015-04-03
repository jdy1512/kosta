<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="abc">
		조건(test)이 abc. (true를 제외한 모든 것은 false) -> false
	</c:if>
	
	<br/>
	<% request.setAttribute("errorMessage", "문제가 발생했습니다."); %>
	<c:if test=" ${ requestScope.errorMessage != null }">
		<font color='red'>오류메세지 : ${ requestScope.errorMessage }</font>
	</c:if>
	
	<br/>
	<% request.setAttribute("age", 19); %>
	메뉴 : 로그아웃, 마이페이지, 장바구니
	<c:if test="${ requestScope.age > 20 }">
		, 성인용품
	</c:if>
	
</body>
</html>