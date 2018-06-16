package com.company;

import java.util.Stack;


/*The calculator should receive an RPN string and return an integer result.
The implementation should support integer add, subtract, multiply and divide operations.

The input string can contain integer operands, +, -, * and / operators and spaces between them.
It is assumed that the input is always a correct RPN string. There is no need for any validity checks.
*/

public class Calculator {

    String[] reversePolishNotation;


    public Calculator(String reversePolishNotation) {
        this.reversePolishNotation = reversePolishNotation.split(" ");
    }


    public int getResult() {

        Stack<Integer> rpn = new Stack<>();
        for (String token: reversePolishNotation){
            if (checkIfItIsOperand(token)) {
                Integer secondOperand = rpn.pop();
                Integer firstOperand = rpn.pop();
                rpn.push(returnResultOfOperation(token, firstOperand, secondOperand));
            }
            else{
                rpn.push(Integer.valueOf(token));
            }

        }

        return rpn.pop();
    }

    public boolean checkIfItIsOperand(String token){
        return token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-");
    }

    public int returnResultOfOperation(String operator, int firstOperand, int secondOperand){
        switch (operator){
            case "*": return firstOperand * secondOperand;
            case "/": return firstOperand / secondOperand;
            case "+": return firstOperand + secondOperand;
            default:  return firstOperand - secondOperand;
        }

    }
}

