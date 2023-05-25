<%-- 
    Document   : invalidInput
    Created on : 21 Apr 2023, 7:30:21 PM
    Author     : MemaniV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invalid Input Page</title>
    </head>
    <body>
        <h1>Invalid input</h1>
        <%
            String errMsg = exception.getMessage();
        %>
        <p>
            The input data is invalid. Please see specific error message below:<br>
            <b>Error message: </b><%=errMsg%>.
        </p>
        <p>
            Please click <a href="question.jsp">here</a> to provide a valid answer.
        </p>
    </body>
</html>
