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
    private Stack<Integer> s1,s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty()&&s2.isEmpty();
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
