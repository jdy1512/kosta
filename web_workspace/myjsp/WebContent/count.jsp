<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%!
	// 선언자(declaration)태그 - JSP -> Servlet. 서블릿의 멤버 변수, 멤버 메소드를 선언
	//                                          메소드 : jspInit(), jspDestroy() 오버라이딩시 사용
	private int counter = 0;
	public void jspInit() {
		System.out.println("jspInit()호출 - 생성시점에 호출되는 라이프사이클 메소드");
	}
	public void jspDestroy() {
		System.out.println("jspDestroy()호출 - 소멸시점에 호출되는 라이프사이클 메소드");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// scriptlet 태크 - _jspService() 에 들어갈 자바코드를 작성하는 태그.
	counter++;
	Date d = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초");
	String date = sdf.format(d);
	int c = (int) (Math.random() * 2);
%>
	당신은 <%= counter %>번째 방문자 입니다.<br/>
	<font color=<%= c == 0 ? "red" : "blue" %>>현재 시간 : <%= date %></font>
	<!-- cout.println(c==0?"red":"blue" -->
	<%-- jsp 주석은 보이지 않음. --%>
</body>
</html>