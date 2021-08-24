package data_structure.stack.data_structure.linked;

import lb.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head==null || head.next==null) {
            return true;
        }
        ListNode slow=head, fast=head;
        ListNode pre =slow, pre2 = null;
        while (fast!=null&&fast.next!=null) {
            pre = slow;
            slow=slow.next;
            fast=fast.next.next;
            pre.next=pre2;
            pre2 = pre;
        }
        if (fast!=null) {
            slow=slow.next;
        }
        while (slow!=null||pre!=null) {
            if (pre.val!=slow.val) {
                return false;
            }
            pre=pre.next; slow=slow.next;
        }
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.isPalindrome(ListNode.arrToLinkedList(new int[]{1,2,2,1})));
        System.out.println(s.isPalindrome(ListNode.arrToLinkedList(new int[]{1,2,3,1})));
        System.out.println(s.isPalindrome(ListNode.arrToLinkedList(new int[]{1,2,1})));
    }
}
