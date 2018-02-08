<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.time.*, java.time.format.*" %>
<%@ page import="java.util.Random" %>
<%--<%@taglib prefix=""%>--%>
<!DOCTYPE html>
<%
    if ("post".equalsIgnoreCase(request.getMethod())) {
        //TODO: doPost

        return;
    }
%>

<jsp:include page='<%="index.jsp"%>'>
    <jsp:param name="param1" value="param1" />
    <jsp:param name="param2" value="1" />
</jsp:include>
<%--<jsp:include page='<%="index.jsp"%>' />--%>


<%!
    int field = 365;

    String getFormattedDate() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
        return f.format(LocalDateTime.now());
    }
%>
<jsp:text>
    Integer x = 2;
</jsp:text>
<html>
<%  pageContext.
    String text = "Hello World";
    if (new Random().nextBoolean()) {
//        response.getWriter().print("Test"); equals next Line
        out.print("Test");
        System.out.println("Test"); // not the same
//        request.setAttribute();
        field++;
    }
    else {
        return;
    }
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Hello World -->
    <%-- Hello World --%>
    <title>Добро пожаловать, JSP!</title>
</head>
<body>
<h1>Добро пожаловать!</h1>
<i>Сегодня <% out.println(getFormattedDate()); %> <%= getFormattedDate() %></i>

<form action="/today.jsp" method="post">

</form>
</body>
</html>
