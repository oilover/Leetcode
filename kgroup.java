package nowcoder.KGroup;

/**
 * Definition for singly-linked list.
 */
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
@Override
public String toString() {
	return "[" + val + "]";
}	
}   

public class Solution {
	static ListNode last,nextFirst;
	public static void test(ListNode head) {
		while (head!=null) {
			System.out.print(head+",");
			head = head.next;
		}
		System.out.println("");
	}
	public static ListNode toNode(int a[]) {
		int n = a.length;
		ListNode head, p = new ListNode(a[0]);
		head = p;
		for (int i=0;i<n-1;i++) {
			p.next = new ListNode(a[i+1]);
			p = p.next;
		}
		return head;
	}
	public static ListNode rever(ListNode head, int n) {
		if (head==null || n==0) return null;
		if (head.next==null || n==1) {
			nextFirst = head.next;
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
	public static void main(String[] args) {
		ListNode t1 = new ListNode(1), t2 = new ListNode(2);
		t1.next = t2;
		t2.next = new ListNode(3);
		int a[] = {2,3,4,5,6};
		a = new int[]{1,2};
		t1 = toNode(a);
		ListNode l = new Solution().reverseKGroup(t1, 3);
		System.out.print("Answer:");test(l);
		System.out.println("Finished");
		
	}
}
