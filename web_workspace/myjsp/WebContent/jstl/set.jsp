<%@page import="servlet.vo.Address"%>
<%@page import="servlet.vo.Member"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 
   <set>
   1. 속성영역에 Attribute를 binding - var(Attribute이름), scope(저장영역), value(속성)
   2. binding된 Attribute의 property 값을 변경 - target(속성지정), property(property:setter), value(값)
 -->
 
<c:set var="errorMessage" value="오류가 발생했습니다." scope="request"/>
<!-- request.setAttribute("오류가 발생했습니다"); -->

<c:set var="name" scope="session">
   홍길동
</c:set>
<!--  request.setAttribute("name","홍길동") -->
${requestScope.errorMessage } -${sessionScope.name}<p>
<c:set var="member" scope="request" value='<%=new Member("id-1","1111","김영수",22,false, new Address("id-1111","111-111","집")) %>'/>
이름 : ${requestScope.member.name }-${requestScope.member.age }<p>

Session에러메세지 : ${sessionScope.sessionError }<br>
<c:set var="sessionError" scope="session" value="${requestScope.errorMessage }"/>
Session에러메세지 : ${sessionScope.sessionError}<br>
<!-- attribute의 property 값을 변경 -->
<c:set target="${requestScope.member}" property="name" value="홍길동"/>
<!-- request.getAttribute("member").setName("홍길동")-->
이름 : ${requestScope.member.name }-${requestScope.member.age }<p>

<c:set target="${requestScope.member }" property="age" value="35"/>
나이 : ${requestScope.member.name }-${requestScope.member.age }<p>

<a href="remove.jsp"> remove.jsp 요청</a>


</body>
</html>