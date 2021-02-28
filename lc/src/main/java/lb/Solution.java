package lb;

import java.util.*;

/*
// Definition for a Node.
*/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    void copy(Node head) {
        if (head==null) return;
        copy(head.next);
        Node p = new Node(head.val);
        p.next = head.next;
        head.next = p;
    }
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        copy(head);
        Stack<Integer> s = new Stack<Integer>();
        Node cur = head;
        while(cur.next!=null && cur.next.next!=null) {
            Node p = cur.next;
            if (cur.random!=null) {
                p.random = cur.random.next;
            }
            cur = p.next;
        }
        cur = head;
        Node newHead = head.next;
        Node p = newHead;
        while(cur!=null && cur.next!=null ) {
            cur.next = cur.next.next;
            if (p.next!=null) p.next = p.next.next;
            cur = cur.next;
            p = p.next;
        }
        return newHead;
    }
    static  void f(Integer a) {
        a = 6;
    }
    public static void main(String[] args) {
        Node p = new Node(7);
        p.next = new Node(3);
        p.next.random = p;
//        (new Solution()).copyRandomList(p);
        List<Integer> a = new ArrayList<Integer>();
        a.add(2);
        List<Integer> b = a;
        a.add(3);
        Integer x = 2; f(x);
        System.out.println(x);
    }
}
