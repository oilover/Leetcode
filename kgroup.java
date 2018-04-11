public class Solution {
	static ListNode last,nextFirst;
    public static ListNode rever(ListNode head, int n) {
		if (head==null || n==0) return null;
		if (head.next==null || n==1) {
		//	nextFirst = head.next;
			return head;
		}
		ListNode t = rever(head.next,n-1);
		head.next.next = head;
		head.next = null;
		return t;
	}
	public static ListNode getK(ListNode p, int k) {
		int i=0;
		while (p!=null && p.next!=null && i<k) {
			p=p.next; i++;
		}
		return p;
	}
	public static ListNode _reverseKGroup(ListNode head, int k) {
		if (head==null ) return null;
		if (head.next==null || k==1) return head;
        ListNode tmp = head, ret = null, last = head;
        int i;
        for (i=0;i<k-1;i++) {
        	if (last.next==null) break;
        	else last = last.next;
        }
        if (i<k-1) return head;
        ListNode nextHead = _reverseKGroup(last.next, k);
        ListNode result = rever(head, k);
        head.next = nextHead;
        return result;
    }
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head==null ) return null;
		if (head.next==null || k==1) return head;
        
        return _reverseKGroup(head, k);
    }
}
