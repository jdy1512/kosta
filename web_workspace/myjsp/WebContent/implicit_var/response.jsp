<%@ page contentType="text/html;charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Response</title>
</head>
<body>
<h2>전송된 요청 파라미터 값</h2>
ID : <%=request.getParameter("id") %><br/>
패스워드 : <%=request.getParameter("password") %><br/>
이름 : <%=request.getParameter("name") %>
<hr/>
ServletConfig를 통해 초기파라미터를 조회 : 
<%=config.getInitParameter("email") %><br/>
<hr/>
회사명 : <%=application.getInitParameter("company name") %><br/>
주소 : <%=application.getInitParameter("address") %><br/>
전화번호 : <%=application.getInitParameter("tel") %>
</body>
</html>