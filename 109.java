/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static TreeNode toBST(ListNode head, int len) {
        if (head==null || len<=0) return null;
        TreeNode t = new TreeNode(head.val);
        if (head.next==null || len<=1) return t;
        ListNode slow = head, fast = head;
        int left = 1, n = 1;
        while (fast.next!=null && n<len) {
            slow = slow.next; left++;           
            if (fast.next!=null && n<len) { fast = fast.next;  n++; }
            if (fast.next!=null && n<len) { fast = fast.next; n++; }
        }
        // cout<<n<<endl;
        TreeNode rt = new TreeNode(slow.val);
        rt.left = toBST(head, left-1);
        rt.right = toBST(slow.next, n-left);
        return rt;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return toBST(head, Integer.MAX_VALUE);
    }
}
