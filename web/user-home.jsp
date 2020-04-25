<%-- 
    Document   : user-home
    Created on : Apr 25, 2020, 4:05:19 PM
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Home Page</title>
    </head>
    <body>
        <h1> Hello back <%=request.getParameter("username") %> </h1>
        <% session.setAttribute("username", request.getParameter("username"));
           session.setAttribute("dbManager", getServletContext().getAttribute("dbManager"));
        %>
        
        <a href ="sub_pages/balance_overview.jsp">Go to overview</a>
        
    </body>
</html>
