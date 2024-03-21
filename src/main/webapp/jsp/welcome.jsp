<%--
  Created by IntelliJ IDEA.
  User: Oier Cao
  Date: 08/03/2024
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <% HttpSession session = request.getSession(false);
       if (session != null){
           String username = (String) session.getAttribute("username");%>
           <h3>ONGI ETORRI, <%= username%></h3>
           <a href="/ws/servlet/Main">Reload MainServlet</a>
           <br/>
           <a href="/ws/jsp/welcome.jsp">Reload Welcome.jsp</a>
           <br/><br/>
           <a href="/ws/servlet/Main?logout=true">Log Out</a>
    <% }
       else { %>
           <a href="login_form.jsp">Log in</a>
    <% } %>

</body>
</html>
