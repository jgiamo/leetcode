package main.java;

import java.util.Stack;

/**
 * 最小栈
 */
public class MinStack {


    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> minNumStack;
    public MinStack() {
        stack = new Stack<>();
        minNumStack = new Stack<>();
    }

    public void push(int x) {
        if(minNumStack.isEmpty() || minNumStack.peek() >= x){
            minNumStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if(minNumStack.peek().equals(stack.pop())){
            minNumStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minNumStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);

        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.getMin();
    }

}
