package main.java;

import java.util.Stack;

/**
 * 反转字符串
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        Stack<String> stack =new Stack();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(stringBuilder.length() > 0){
                    stack.push(stringBuilder.toString());
                    stringBuilder.delete(0,stringBuilder.length());
                }else{
                    continue;
                }
            }else{
                stringBuilder.append(s.charAt(i));
            }
        }
        if(stringBuilder.length() > 0){
            stack.push(stringBuilder.toString());
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop()).append(" ");
        }
        if(result.length()>=1){
            return result.substring(0, result.length()-1);
        }
        else {
            return result.toString();
        }
    }

    public static void main(String[] args) {


        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        reverseWordsInAString.reverseWords("");


    }

}
