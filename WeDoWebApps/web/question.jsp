<%-- 
    Document   : question
    Created on : 21 Apr 2023, 5:18:16 PM
    Author     : MemaniV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question Page</title>
    </head>
    <body>
        <%
            String question = (String)session.getAttribute("question");
            Integer questionNum = (Integer)session.getAttribute("questionNum");
            Integer totNumQuestions = (Integer)session.getAttribute("totNumQuestions");
        %>
        <h1>Question <b><%=questionNum%></b> of <b><%=totNumQuestions%></b></h1>
        <p>
            <%=question%>
        </p>
        <form action="AnswerServlet.do" method="POST">
            <table>
                <tr>
                    <td>Answer: </td>
                    <td><input type="text" name="answer"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="SUBMIT"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
