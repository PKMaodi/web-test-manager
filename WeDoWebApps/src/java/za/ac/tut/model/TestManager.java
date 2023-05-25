/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author MemaniV
 */
public class TestManager implements TestManagerInterface  {   
    public List<String> createTest(){
        List<String> test = new ArrayList<>();
        
        test.add("1 + 1 = ?\n A. 1 \nB. 11 \nC. 2 \nD. 0,C");
        test.add("1 * 1 = ?\n A. 1 \nB. 11 \nC. 2 \nD. 0,A");
        test.add("1 / 1 = ?\n A. 1 \nB. 11 \nC. 2 \nD. 0,A");
        test.add("1 - 1 = ?\n A. 1 \nB. 11 \nC. 2 \nD. 0,D");
        test.add("1 % 1 = ?\n A. 1 \nB. 11 \nC. 2 \nD. 0,D");
        test.add("(1 + 1)*2 = ?\n A. 1 \nB. 2 \nC. 4 \nD. 6,C");
        test.add("(1 + 1)/2 = ?\n A. 1 \nB. 2 \nC. 4 \nD. 6,A");
        
        return test;
    }

    @Override
    public List<String> getStudentTest(List<String> test) {
        List<String> studentTest = new ArrayList<>();

        int index;
        Random random = new Random();
        
        for(int i = 0; i < 5; i++){
            index = random.nextInt(7);//Math.floor(Math.random()*data.size());
            studentTest.add(test.get(index));
        }
        
        return studentTest;
    }
    
    public String getQuestion(List<String> studentTest, Integer index) {
        String questionAndAnswer = studentTest.get(index);
        String[] questionAndAnswerTokens = questionAndAnswer.split(",");
        String question = questionAndAnswerTokens[0];
        return question;
    }
    
    public String getAnswer(List<String> studentTest, Integer index) {
        String questionAndAnswer = studentTest.get(index);
        String[] questionAndAnswerTokens = questionAndAnswer.split(",");
        String answer = questionAndAnswerTokens[1];
        return answer;
    }
}
