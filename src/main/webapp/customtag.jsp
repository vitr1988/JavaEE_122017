<%@page language="java" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@ taglib uri="/custom" prefix="cc" %>
<html>
<head>
    <title>Счетчик посещаемости</title>
</head>
Hello, username.
This is <cc:counter/> times of entering this page!
<% int a = 1; %>
<%@include file="include.jsp"%>
<jsp:include page="includeAction.jsp">
    <jsp:param name="address" value="Samara, Lenina str"/>
</jsp:include>

</body>
</html>