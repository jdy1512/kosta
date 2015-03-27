<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%!
	private int counter; 
	public void jspInit(){
		System.out.println("jspInit 호출");
	}
	public void jspDestroy(){
		System.out.println("jspDestroy 호출");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Counter</title>
</head>
<body>
	<%
		counter++; 
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초");
		int c = (int)(Math.random()*5);
		
	%>

	당신은 <%=counter %>번째 방문객 입니다.<br/>
	<font color="<%=c==0?"blue":c==1?"red":c==2?"green":c==3?"yellow":"black" %>">현재시각은 <%=sdf.format(d) %>입니다.</font>
	<!-- c==0?"blue":c==1?"red":c==2?"green":c==3?"yellow":"black" <%=counter %>-->
	<%-- c==0?"blue":c==1?"red":c==2?"green":c==3?"yellow":"black" --%>
</body>
</html>