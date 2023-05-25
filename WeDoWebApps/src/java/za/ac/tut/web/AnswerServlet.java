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
import za.ac.tut.model.InputValidator;

/**
 *
 * @author MemaniV
 */
public class AnswerServlet extends HttpServlet {
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String question = (String)session.getAttribute("question");
        
        String studentAnswer = request.getParameter("answer");
        System.out.println("Answer = " + studentAnswer);
        System.out.println("Size = " + studentAnswer.length());
        System.out.println("Outcome = " + studentAnswer.equals("A"));
        InputValidator iv = new InputValidator();
        iv.validateAnswer(studentAnswer);
        
        List<String> studentTest = (List<String>)session.getAttribute("studentTest");
        Integer index = (Integer)session.getAttribute("index");
        String url = "outcome.jsp";
        
        String correctAnswer = getCorrectAnswer(studentTest, index);
        String outcome = determineOutcome(studentAnswer, correctAnswer);
        updateSession(session, index, question, studentAnswer, correctAnswer, outcome);
        
        if(index == 4){
            url = "end_of_test.jsp";
        }
        RequestDispatcher disp = request.getRequestDispatcher(url);
        disp.forward(request, response);        
    }

    private String getCorrectAnswer(List<String> studentTest, Integer index) {
        String questionAndAnswer = studentTest.get(index);
        String[] questionAndAnswerTokens = questionAndAnswer.split(",");
        String answer = questionAndAnswerTokens[1];
        return answer;
    }

    private String determineOutcome(String answer, String correctAnswer) {
        String outcome = "Wrong";
        
        if(answer.equals(correctAnswer)){
            outcome = "Correct";
        }
        
        return outcome;
    }

    private void updateSession(HttpSession session, Integer index, String question, String studentAnswer, String correctAnswer, String outcome) {
        if(outcome.equals("Correct")){
            Integer score = (Integer)session.getAttribute("score");
            score++;
            session.setAttribute("score", score);
        }
        
        List<String> questions = (List<String>)session.getAttribute("questions");
        List<String> studentAnswers = (List<String>)session.getAttribute("studentAnswers");
        List<String> correctAnswers = (List<String>)session.getAttribute("correctAnswers");
        List<String> outcomes = (List<String>)session.getAttribute("outcomes");
        
        questions.add(index, question);
        studentAnswers.add(index, studentAnswer);
        correctAnswers.add(index, correctAnswer);
        outcomes.add(index, outcome);
        index++;
        
        session.setAttribute("questions", questions);
        session.setAttribute("studentAnswers", studentAnswers);
        session.setAttribute("correctAnswers", correctAnswers);
        session.setAttribute("outcomes", outcomes);
        session.setAttribute("index", index);
    }
}
