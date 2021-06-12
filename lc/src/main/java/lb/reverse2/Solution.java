package lb.reverse2;

import lb.ListNode;

public class Solution {
    final ListNode dummy = new ListNode(-1);
    public static ListNode reverse(ListNode p) {
        ListNode head=null,next;
        for (; p!=null; p=next) {
            next=p.next;
            p.next = head;
            head = p;
        }
        return head;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        dummy.next = head;
        ListNode p = dummy;
        int i=0;
        ListNode p1 = null, p2 = null;
        for ( i=0;i<right&&p.next!=null;i++,p=p.next) {
            if (i==left-1) {
                p1 = p;
            }
        }
        if (p1==null || p1.next==null) {
            return head;
        }
        if (i==right) {
            p2 = p;
        }
        ListNode p3 = null;
        if (p2!=null) {
            p3 = p2.next;
            p2.next = null;
        }
        ListNode tmp = p1.next;
        p1.next = reverse(p1.next);
        tmp.next = p3;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode p,q;
//        ListNode p = ListNode.arrToLinkedList(new int[]{1,2,3});
//        ListNode q = ListNode.reverse(p);
        p = ListNode.arrToLinkedList(new int[]{1,2,3,4,5});
        q = s.reverseBetween(p, 2, 4);
        q.print();
    }
}
