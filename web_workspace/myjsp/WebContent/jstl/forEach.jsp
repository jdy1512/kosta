<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ForEach</title>
</head>
<body>
	<%
		int[] nums = { 10, 20, 30, 40, 50, 60, 70 };
		request.setAttribute("nums", nums);
	%>
	<h3>forEach를 이용해 배열값 출력</h3>
	<c:forEach items="${ requestScope.nums }" var="num">
		<!-- 반복 코드 -->
		${ num }
	</c:forEach>
	
	<br/>
	<hr/>
	<%
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("1");
		strList.add("2");
		strList.add("3");
		strList.add("4");
		strList.add("5");
		strList.add("6");
		request.setAttribute("list", strList);

		HashMap<String, String> strMap = new HashMap<String, String>();
		strMap.put("1", "a");
		strMap.put("2", "b");
		strMap.put("3", "c");
		strMap.put("4", "d");
		strMap.put("5", "e");
		strMap.put("6", "f");
		request.setAttribute("map", strMap);
	%>

	<c:forEach items="${requestScope.list }" var="list">
		list : ${list } <br />
	</c:forEach>

	<c:forEach items="${requestScope.map }" var="map">
		키 : ${map.key } - 값 : ${map.value } <br />
	</c:forEach>
	<hr />

	<c:forEach var="i" begin="1" end="20" step="2">
		출력 : ${i} <br>
	</c:forEach>

</body>
</html>