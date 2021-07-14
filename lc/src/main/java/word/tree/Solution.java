package word.tree;
class Node {
    int val;
    Node left,right;

    public Node(int val) {
        this.val = val;
    }
}
public class Solution {

    boolean isSymmetric(Node a, Node b) {
        if (a==null && b==null) {
            return true;
        }
        if (a==null || b==null) {
            return false;
        }
        return a.val==b.val && isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);

        Node b = new Node(1);
        b.left = new Node(3);
        b.right = new Node(2);
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(a,b));
        b.right = null;
//        Integer.valueOf()
        System.out.println(solution.isSymmetric(a,b));
        b.left = new Node(2);
        b.right = new Node(3);
        System.out.println(solution.isSymmetric(a,b));
    }
}
