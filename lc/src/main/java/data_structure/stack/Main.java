package data_structure.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyStack {
    private Queue<Integer> que;
    /** Initialize your data structure here. */
    public MyStack() {
        que = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        que.offer(x);
        int n = que.size();
        for (int i=0;i<n-1;i++) {
            x = que.poll();
            que.offer(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        return que.poll();
        // return 0;
    }

    /** Get the top element. */
    public int top() {
        return que.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
class MyQueue {
    private Stack<Integer> stack, helper;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!helper.isEmpty()) {
            return helper.pop();
        }
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }
        return helper.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (helper.isEmpty()) {
            while (!stack.isEmpty()) {
                helper.push(stack.pop());
            }
        }
        return helper.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty()&& helper.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class Main {
    public static void main(String[] args) {

    }
}
