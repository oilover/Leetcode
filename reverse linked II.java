/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public static ListNode getK(ListNode p, int k) {
		int i=0;
		while (p!=null && p.next!=null && i<k-1) { // go (k-1) step
			p=p.next; i++;
		}
		return p;
	}
    static ListNode p2, nxt;
	public static ListNode rever(ListNode head, int n) { // reverse most n nodes
		if (head==null || n==0) return null;
		if (head.next==null || n==1) {  // last node in prepare to reversing part
            nxt = head.next; // nxt is first node after reverse part
			return head;
		}
		ListNode t = rever(head.next,n-1);
		head.next.next = head;
		head.next = null;
		return t;
	}
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1), fi;
        dummy.next = head; fi = dummy;
        ListNode pre_m = dummy, pre = dummy;
        for (int i=1;i<=n;i++) {
        	ListNode tmpNext = head.next;
        	if (i==m) {
        		pre_m = pre;
        		fi = head;
        	}
        //	System.out.println("head:" + head);
        	if (i>m ) {        	
                fi.next = head.next;
        		head.next = pre_m.next;
        		pre_m.next = head;
        	}
        	pre = head;
        	head = tmpNext;//	head.next;
        }
        return dummy.next;
    }
}
