<%-- 
    Document   : balance_overview
    Created on : Apr 25, 2020, 4:27:42 PM
    Author     : Asus
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.xdevapi.Result"%>
<%@page import="java.lang.String"%>
<%@page errorPage = "errorHandler.jsp" %>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.db.DBManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/styling.css">
        <title>Balance overview</title>
    </head>
    <body>
        Balance history: <br>
        
        
        <% String fetchResultsQuery = "select * from wallet_web.expense_history "
                + "where username = ?";

           DBManager manager = (DBManager)getServletContext().getAttribute("dbManager");
           PreparedStatement prStatement = null;
           prStatement = manager.getConnection().prepareStatement(fetchResultsQuery);
           prStatement.setString(1, (String)session.getAttribute("username"));
           ResultSet rs = prStatement.executeQuery();%>
        <table border="1px solid black" >
            <tr>
                <th>Account</th>
                <th>Amount</th>
                <th>Issue date</th>
                <th>Expense type </th>
            </tr>
            
            <% while(rs.next()) { %>
            <TR align="center" >
                <TD> <%= rs.getString("username") %> </Td>
                <TD> <%= rs.getDouble("amount") %> </Td>
                <TD> <%= rs.getDate("issueDate") %> </Td>
                <TD> <%= rs.getDouble("expenseID") %> </Td>
            </TR>
            
            <% } %>
  
        </table>    
    </body>
</html>
