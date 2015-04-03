<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
	EL의 리터럴값(Literal value)
	문자열 : "값", '값'
	숫자 : 정수, 실수, 10, 209.6
	boolean : true/false
	null - 출력이 안되는 값.
	- EL에서 리터럴 값 출력 : ${ '값' } - ${ "abc" }, ${ '안녕' }, ${ 10 }
	
	숫자 : ${ 10 }, ${ 30.7 }<br/>
	문자열 : ${ "안녕하세요" } - ${ 'Hello World' } - ${ "a" == 'a' } - ${ null }
	<br/>
	사칙 연산<br/>
	${ 10 / 2 } - ${ 10 div 2 } - ${ null + 300 }<!-- null은 0으로 처리 --><br/>
	비교 연산<br/>
	${ 10 == 20 } - ${ 10 eq 20 }<br/>
	<!-- empty 값 - 값이 문자열인 경우, null, length가 0이면 true(빈문자열이냐?) -->
	empty : ${ empty "a" }, ${ empty product.id }, ${ empty "" }
	-->
</body>
</html>