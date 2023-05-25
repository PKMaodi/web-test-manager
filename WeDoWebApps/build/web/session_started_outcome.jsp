<%-- 
    Document   : session_started_outcome
    Created on : 21 Apr 2023, 3:46:12 PM
    Author     : MemaniV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Session Started Outcome Page</title>
    </head>
    <body>
        <h1>Session started</h1>
        <%
            String name = (String)session.getAttribute("name");
        %>
        <p>
            Hi <b><%=name%></b>, your session has started. Please click <a href="GetQuestionServlet.do">here</a> get a question.
        </p>
    </body>
</html>
