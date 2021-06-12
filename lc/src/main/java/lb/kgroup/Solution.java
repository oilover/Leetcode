package lb.kgroup;

import lb.ListNode;

import java.util.Stack;

public class Solution {
    final ListNode dummy = new ListNode(-1);
    public ListNode arrToLinkedList(int a[]) {
        ListNode pre = dummy;
        for (int x: a) {
            pre.next = new ListNode(x);
            pre = pre.next;
        }
        return dummy.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode pre = dummy, p = head;
        Stack<ListNode> stack = new Stack<>();
        while (p!=null) {
            int i=0;
            for ( i=0; p!=null && i<k;i++) {
                stack.push(p);
                p = p.next;
            }
            if (i<k) {
                return dummy.next;
            }
            while (!stack.empty()) {
                ListNode t = stack.pop();
                t.next = null;
                pre.next = t;
                pre = pre.next;
            }
            pre.next = p;
        }
        return dummy.next;
    }
}
