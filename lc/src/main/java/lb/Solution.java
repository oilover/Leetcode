package lb;

import java.util.*;

/*
// Definition for a Node.
*/
class RandNode {
    int val;
    RandNode next;
    RandNode random;

    public RandNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    void copy(RandNode head) {
        if (head==null) return;
        copy(head.next);
        RandNode p = new RandNode(head.val);
        p.next = head.next;
        head.next = p;
    }
    public RandNode copyRandomList(RandNode head) {
        if (head==null) return null;
        copy(head);
        Stack<Integer> s = new Stack<Integer>();
        RandNode cur = head;
        while(cur.next!=null && cur.next.next!=null) {
            RandNode p = cur.next;
            if (cur.random!=null) {
                p.random = cur.random.next;
            }
            cur = p.next;
        }
        cur = head;
        RandNode newHead = head.next;
        RandNode p = newHead;
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
        RandNode p = new RandNode(7);
        p.next = new RandNode(3);
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
