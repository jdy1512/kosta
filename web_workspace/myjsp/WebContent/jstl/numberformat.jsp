<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	fmt:formatNumber - 숫자(정수, 실수)를 형식화된 문자로 출력. DecimalFormat의 역할을 태그화
	속성
	value : 변경할 값을 지정
	type : number | currency | percent(value*100 한 값에 %를 붙인다. 그래서 value/100 한 값을 넣는다.)
	groupingUsed = true(기본) | false - 자릿수 구분자 추가 여부 지정
	maxFractionDigits : 값-정수 - 소수점이하 최대 자릿수
	minFractionDigits : 값-정수 - 소수점이하 최소 자릿수
	maxIntegerDigits : 값-정수 - 정수부 최대 자릿수
	minIntegerDigits : 값-정수 - 정수부 최소 자릿수
	pattern : 전환문자를 이용해서 출력 형식 패턴을 직접 지정(패턴문자 #, 0 이용)
	 -->
	<c:set scope="request" value="1234567.1234" var="num"/>
	1) <fmt:formatNumber value="${ requestScope.num }" type="number"/><br/>
	2) <fmt:formatNumber value="${ requestScope.num }" type="currency"/><br/>
	3) <fmt:formatNumber value="${ requestScope.num }" type="percent"/><br/>
	4) <fmt:formatNumber value="${ requestScope.num }" type="number"
	 maxFractionDigits="2" groupingUsed="false" maxIntegerDigits="3"/><br/>
	5) <fmt:formatNumber value="${ requestScope.num }" type="number"
	 pattern="#,####.######"/><br/>
	 <fmt:setLocale value="en_US"/>
	6) <fmt:formatNumber value="${ requestScope.num }" type="currency"/><br/>
	 <fmt:setLocale value="zh_CN"/>
	7) <fmt:formatNumber value="${ requestScope.num }" type="currency"/><br/>
</body>
</html>