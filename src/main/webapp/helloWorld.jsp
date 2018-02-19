<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="custom" uri="/tld" %>
<%@ taglib prefix="counter" uri="/custom" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Hello World
    <jsp:include page="index.jsp"/>
    ${ 2 + 2 }

    <custom:customstyle size="6">
        Hello World!
    </custom:customstyle>

    <div>
        Эту страницу посещали <counter:counter /> раз.
    </div>
</body>
</html>
