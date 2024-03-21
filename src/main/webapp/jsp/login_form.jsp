<%--
  Created by IntelliJ IDEA.
  User: cvzcaoio
  Date: 2023-03-06
  Time: 11:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%  Object login_error_aux = request.getAttribute("login_error");
        Object log_out_aux = request.getAttribute("log_out");
        if(login_error_aux != null) {
            if((boolean) login_error_aux) { %>
            <h3>LOGIN ERROR!!!</h3>
    <%      }
        }
        else if (log_out_aux != null) {
            if((boolean) log_out_aux) { %>
            <h3>LOG OUT!!!</h3>
    <%      }
        } %>

<form method="POST" action="/ws/servlet/Login">
    Erabiltzailea: <input type="text" name="username"/><br/>
    Pasahitza: <input type="text" name="password"/><br/>
    <input type="submit"/>
</form>

</body>
</html>
