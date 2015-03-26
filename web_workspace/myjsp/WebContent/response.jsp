<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>전송된 요청파라미터 값</h2>
	ID : <%= request.getParameter("id")%><br/>
	패스워드 : <%= request.getParameter("password") %><br/>
	이름 : <%= request.getParameter("name") %><br/>
	<hr/>
	<h2>ServletConfig를 통해 초기 파라미터 값 조회</h2>
	<%= config.getInitParameter("email") %>
	<hr/>
	<%
	String str = "안녕";
	if(true) {
		out.println(str + "--");
	}
	%>
	<hr/>
	<!-- 내장객체 application = ServletContext객체 -->
	회사명 : <%= application.getInitParameter("company name") %><br/>
	전화번호 : <%= application.getInitParameter("tel") %><br/>
	회사주소 : <%= application.getInitParameter("address") %>
</body>
</html>