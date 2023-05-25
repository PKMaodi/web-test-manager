/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.TestManager;

/**
 *
 * @author MemaniV
 */
public class StartSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String name = request.getParameter("name");
        String url = "session_started_outcome.jsp";
        
        initialiseSession(session, name);
        
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);
    }

    private void initialiseSession(HttpSession session, String name) {
        Integer score = 0, numQuestionsAsked = 0, index = 0, questionNum = 0, totNumQuestions = 5;
        TestManager tm = new TestManager();
        List<String> test = tm.createTest();
        List<String> studentTest = tm.getStudentTest(test);
       
        List<String> questions = new ArrayList<>();
        List<String> studentAnswers = new ArrayList<>();
        List<String> correctAnswers = new ArrayList<>();
        List<String> outcomes = new ArrayList<>();

        
        session.setAttribute("name", name);
        session.setAttribute("studentTest", studentTest);
        session.setAttribute("score", score);
        session.setAttribute("index", index);
        session.setAttribute("questionNum", questionNum);
        session.setAttribute("totNumQuestions", totNumQuestions);
        session.setAttribute("numQuestionsAsked", numQuestionsAsked);
        session.setAttribute("questions", questions);
        session.setAttribute("studentAnswers", studentAnswers);
        session.setAttribute("correctAnswers", correctAnswers);
        session.setAttribute("outcomes", outcomes);
    }

}
