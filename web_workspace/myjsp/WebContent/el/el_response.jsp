<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>요청파라미터 값들을 출력(EL이용) - param/paramValues 기본객체 이용</h2>
	Name : ${ param.name }<br/>
	나이 : ${ param.age }<br/>
	취미 : ${ paramValues.hobby[0] }, ${ paramValues.hobby[1] }, ${ paramValues.hobby[2] }
	<br/>
	<h2>EL을 이용해 클라이언트가 전송한 Cookie값 출력 - cookie.이름.value</h2>
	cookie_id : ${ cookie.cookie_id.value }<br/>
	now : ${ cookie.now.value }
	<br/>
	<h2>EL을 이용해 초기파라미터 출력</h2>
	전화번호 : ${ initParam.tel }<br/>
	주소 : ${ initParam.address }<br/>
	회사명 : ${ initParam.company_name }<br/>
</body>
</html>