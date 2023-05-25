/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MemaniV
 */
public class GetQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<String> studentTest = (List<String>)session.getAttribute("studentTest");
        Integer index = (Integer)session.getAttribute("index");
        Integer questionNum = (Integer)session.getAttribute("questionNum");
        String url = "question.jsp";
        
        String question = getQuestion(studentTest, index);
        questionNum++;
        session.setAttribute("question", question);
        session.setAttribute("questionNum", questionNum);
        
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
        
    }

    private String getQuestion(List<String> studentTest, Integer index) {
        String questionAndAnswer = studentTest.get(index);
        String[] questionAndAnswerTokens = questionAndAnswer.split(",");
        String question = questionAndAnswerTokens[0];
        return question;
    }
}
