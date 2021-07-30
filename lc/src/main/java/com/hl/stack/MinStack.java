package com.hl.stack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
//import java.util.Thr
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    void push(int x) {
        if (min.isEmpty() || x<min.peek()) {
            min.push(x);
            List<Integer> res = new LinkedList<>();
            Iterator<Integer> it = res.iterator();
        }
        stack.push(x);
    }
    int pop() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception("err");
        }
        if (stack.peek() == min.peek()) {
            min.pop();
        }
        return stack.pop();
    }
    int getMin() throws Exception {
        if (stack.isEmpty()) {
            throw new Exception("err");
        }
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
    }
}
