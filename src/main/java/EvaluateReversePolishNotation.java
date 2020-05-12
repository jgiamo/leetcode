package main.java;

import java.math.BigInteger;
import java.util.Stack;

/**
 * 逆波兰表达式，后缀求值表达式
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            } else if (tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (tokens[i].equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if (tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

        String[] tokens = new String[]{"4", "13", "5", "/", "+"};

        EvaluateReversePolishNotation evaluateReversePolishNotation = new EvaluateReversePolishNotation();
        evaluateReversePolishNotation.evalRPN(tokens);


    }

}
