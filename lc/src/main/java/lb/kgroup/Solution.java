package lb.kgroup;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
    final ListNode dummy = new ListNode(-1);
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null) return head;
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
            ListNode next = p;
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
