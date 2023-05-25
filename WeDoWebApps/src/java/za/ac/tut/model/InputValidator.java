/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model;

/**
 *
 * @author MemaniV
 */
public class InputValidator implements ErrorMessages {
    public InputValidator(){
    }
    
    public void validateAnswer(String answer)throws TestException {
        if(isAnswerEmpty(answer)){
            throw  new TestException("Empty answer. Please enter something valid.");
        } 
        
        if (!isAnswerValid(answer)){
            System.out.println("Answer is invalid.");
            throw new TestException(INVALID_ANSWER);
        }
    }

    private boolean isAnswerEmpty(String answer) {
        boolean isValid = false;
        
        if(answer.length() == 0){
            isValid = true;
        }
        
        return isValid;
    }

    private boolean isAnswerValid(String answer) {
        boolean isValid = false;
        
        if((answer.equals("A")) || (answer.equals("B")) || (answer.equals("C")) || (answer.equals("D"))){
            isValid = true;
            System.out.println("Answer is valid.");
        }
        
        return isValid;
    }
    
}
