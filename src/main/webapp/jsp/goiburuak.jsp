<%--
  Created by IntelliJ IDEA.
  User: Oier Cao
  Date: 01/03/2024
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>GOIBURUEN IZENA</th>
            <th>GOIBURUEN BALIOA</th>
        </tr>

        <% Enumeration<String> goiburuak = request.getHeaderNames();
           while(goiburuak.hasMoreElements()){
               String izena = (String) goiburuak.nextElement();
               String balioa = request.getHeader(izena); %>
        <tr>
            <td> <%= izena %> </td>
            <td> <%= balioa %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
