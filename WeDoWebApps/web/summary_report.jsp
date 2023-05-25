<%-- 
    Document   : summary_report
    Created on : 21 Apr 2023, 6:24:23 PM
    Author     : MemaniV
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary Report Page</title>
        <style>
        table, th, td {
          border: 1px solid black;
          border-collapse: collapse;
        }
</style>
    </head>
    <body>
        <h1>Summary report</h1>
        <%
            String name = (String)session.getAttribute("name");
            Integer totNumQuestions = (Integer)session.getAttribute("totNumQuestions");
            Integer score = (Integer)session.getAttribute("score");
            Double percScore = ((double)score/totNumQuestions);
            DecimalFormat df = new DecimalFormat("0%");
            List<String> questions = (List<String>)session.getAttribute("questions");
            List<String> studentAnswers = (List<String>)session.getAttribute("studentAnswers");
            List<String> correctAnswers = (List<String>)session.getAttribute("correctAnswers");
            List<String> outcomes = (List<String>)session.getAttribute("outcomes");
        %>
        <p>
            Below is the test outcome:
        </p>
        <table >
            <tr>
                <td>Student name:</td>
                <td><%=name%></td>
            </tr>
            <tr>
                <td>Total number of questions:</td>
                <td><%=totNumQuestions%></td>
            </tr>
            <tr>
                <td>Score:</td>
                <td><%=df.format(percScore)%></td>
            </tr>
            <tr>
                <th><b>No.</b></th>
                <th><b>Question</b></th>
                <th><b>Student answer</b></th>
                <th><b>Correct answer</b></th>
                <th><b>Outcome</b></th>
            </tr>
            <%
                for(int i = 0; i < 5; i++) {
                    String question = questions.get(i);
                    String studentAnswer = studentAnswers.get(i);
                    String correctAnswer = correctAnswers.get(i);
                    String outcome = outcomes.get(i);
                    %>

                    <tr>
                        <td><%=i+1%></td>
                        <td><%=question%></td>
                        <td><%=studentAnswer%></td>
                        <td><%=correctAnswer%></td>
                        <td><%=outcome%></td>
                    </tr>
                    <%
                }
            %>
        </table>
        <p>
            Please click <a href="EndSessionServlet.do">here</a> to end the session.
        </p>
    </body>
</html>
