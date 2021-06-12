package lb;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    static final ListNode dummy = new ListNode(-1);

    public int getVal() {
        return val;
    }
    public static ListNode reverse(ListNode p) {
        ListNode head=null,next;
        for (; p!=null; p=next) {
            next=p.next;
            p.next = head;
            head = p;
        }
        return head;
    }
    public static ListNode arrToLinkedList(int a[]) {
        ListNode pre = dummy;
        for (int x: a) {
            pre.next = new ListNode(x);
            pre = pre.next;
        }
        return dummy.next;
    }
    public void print()
    {
        System.out.println(this.val + " ");
        if (this.next!=null) {
            this.next.print();
        }
    }
}