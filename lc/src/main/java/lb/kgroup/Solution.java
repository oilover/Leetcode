package lb.kgroup;

import lb.ListNode;

import java.util.*;

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
    private ListNode reverse(ListNode head) {
        dummy.next = head;
        ListNode p = head;
        while (p!=null) {
            ListNode tmp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = tmp;
        }
        return dummy.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null) {
            return null;
        }
        ListNode p = head;
        int i;
        for (i = 0; i < k-1; i++) {
            if (p.next==null) {
                break;
            }
            p = p.next;
        }
//        不满k节点，不翻转
        if (p.next==null && i<k-1) {
            return head;
        }
        ListNode nextHead = p.next;
        p.next = null;
        ListNode oldHead = head;
        ListNode newHead = reverse(head);
        oldHead.next = reverseKGroup(nextHead, k);
        return newHead;
    }
    public ListNode reverseKGroup2(ListNode head, int k) {
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

    public static void main(String[] args) {
        List<Integer>[] l ;
        l = new List[5];
        l[0] = new ArrayList<>();
        l[0].add(8);
        l[1] = Arrays.asList(3,7);
        System.out.println(l[0]);
        System.out.println(l[1]);
    }
}
