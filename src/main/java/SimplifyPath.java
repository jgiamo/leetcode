package main.java;

import java.util.Stack;

/**
 * 简化路径,这道题开始时候我的思路错了，只想到压栈，却漏掉了要怎么压栈  **
 * 忘记了stack数据结构也是可以顺序遍历的
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : arr) {
            if (str.isEmpty() || str.equals(".") || str.equals("..")) {
                if (str.equals("..") && !stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        if(stack.isEmpty()){
            return "/";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<stack.size();i++) {
            stringBuilder.append("/").append(stack.get(i));
        }
        return stringBuilder.toString();


    }

//    public String simplifyPath(String path) {
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < path.length(); i++) {
//
//            if (path.charAt(i) == '.') {
//                if (stack.peek() == '.') {
//                    stack.pop();
//                    if(stack.size() > 1) {
//                        stack.pop();
//                    }
//                    while(stack.size() > 1 && stack.peek() != '/'){
//                        stack.pop();
//                    }
//                } else {
//                    stack.push('.');
//                }
//            } else if (path.charAt(i) == '/') {
//                if (stack.isEmpty()) {
//                    stack.push('/');
//                } else {
//                    if (stack.peek() == '/') {
//                        continue;
//                    } else if (stack.peek() == '.') {
//                        stack.pop();
//                    } else {
//                        stack.push('/');
//                    }
//                }
//            } else {
//                stack.push(path.charAt(i));
//            }
//        }
//        if(stack.size() > 1){
//            if(stack.peek() == '/'){
//                stack.pop();
//            }
//            if(stack.peek() == '.'){
//                stack.pop();
//            }
//
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        while(!stack.isEmpty()){
//            stringBuilder.append(stack.pop());
//        }
//        return stringBuilder.reverse().toString();
//
//    }


    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();

        System.out.println(simplifyPath.simplifyPath("/../"));

    }

}
