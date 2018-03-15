<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JAX-RS Create User</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/api/user" method="post">
        <div>
            <label for="username">Username:</label>
            <input id="username" name="username" type="text" placeholder="Enter your login.."/>
        </div>
        <div>
            <label for="firstname">Firstname:</label>
            <input id="firstname" name="firstname" type="text" placeholder="Enter your firstname.."/>
        </div>
        <div>
            <label for="lastname">Lastname:</label>
            <input id="lastname" name="lastname" type="text" placeholder="Enter your lastname.."/>
        </div>
        <div>
            <label for="email">Email:</label>
            <input id="email" name="email" type="text" placeholder="Enter your email.."/>
        </div>
        <input type="submit" value="Create user"/>
    </form>
</body>
</html>
