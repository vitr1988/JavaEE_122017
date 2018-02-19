<%@page language="java" pageEncoding="UTF-8" contentType="text/html; UTF-8"
    errorPage="exception.jsp" %>
<%@ taglib uri="/custom" prefix="cc" %>
<html>
<head>
    <title>Разница между jsp действием и директивой</title>
</head>
<% int a = 1; %>
<%@include file="include.jsp"%>
<%--
<jsp:include page="include.jsp"/>

<jsp:include page="include.jsp"/>
<jsp:include page="index.jsp"/>--%>

<jsp:include page="includeAction.jsp">
    <jsp:param name="address" value="Samara, Lenina str"/>
</jsp:include>

</body>
</html>