<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.*, java.time.format.*" %>
<%!
    String getFormattedDate() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
        return f.format(LocalDateTime.now());
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добро пожаловать, JSP!</title>
</head>
<body>
<h1>Добро пожаловать!</h1>
<i>Сегодня <%= getFormattedDate() %></i>
</body>
</html>
