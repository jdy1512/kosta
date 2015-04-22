<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	response.setHeader("cache-control", "no-cache");
%>
이것이 붙을 까요?<br>
${param.id}-${param.pwd}<br>
<%=request.getMethod() %><br>
