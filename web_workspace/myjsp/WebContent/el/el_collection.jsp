<%@page import="java.util.HashMap"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String[] names = { "김철수", "이영희", "박길동" };
	request.setAttribute("names", names);

	session.setAttribute("list", names);
	
	HashMap map = new HashMap();
	map.put("productName", "TV");
	map.put("maker", "LG");
	map.put("price", 20000);
	request.setAttribute("product", map);
	%>
	<h2>EL을 이용해 배열의 값 조회</h2>
	${ requestScope.names["0"] } - ${ requestScope.names[1] } - ${ requestScope.names['2'] } - ${ requestScope.names['3'] }
	<h2>EL을 이용해 List값 조회</h2>
	${ sessionScope.list[0] } - ${ sessionSocpe.list[1] }<br/>
	${ sessionScope.lise[2] } , ${ sessionSocpe.list[3] }<br/>
	회원나이가 20세 미만인가? ${ sessionScope.list[2].age < 20 ? '미성년' : '성년' }<br/>
	회원의 이름이 김영철인가? ${ sessionSocpe.lise[2].name == '김영철' ? '개그맨' : '일반인' }<br/>
	<h2>EL을 이용해 Map의 값들을 조회</h2>
	제품명 : ${ requestScope.product.productName }<br/>
	메이커 : ${ requestScope.product.maker }<br/>
	가격 : ${ requestScope.product.price }<br/>
	<!-- 최고가 : ${ requestScope.product['high price'] }<br/>  -->
	
</body>
</html>