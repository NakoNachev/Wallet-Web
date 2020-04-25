<%-- 
    Document   : errorHandler
    Created on : Apr 25, 2020, 5:10:41 PM
    Author     : Asus
--%>

<%@page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Handler</title>
    </head>
    <body>
        <h2>
            
            Error: <%=exception.getClass().getName() %><br/>
            <%=exception.getMessage() %><br/> 
        </h2>
    </body>
</html>
