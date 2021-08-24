package tree.bst;

import tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Result {
    boolean isBST;
    int min,max;
    int n;
    public Result(boolean isBST, int min, int max, int n) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.n = n;
    }
}
class Solution {
    int ans;
    Result dfs(TreeNode u) {
        if (u==null) {
            return new Result(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        Result left = dfs(u.left);
        Result right = dfs(u.right);
        boolean isBST = left.isBST && right.isBST;
        if (u.left!=null && u.val<=left.max) {
            isBST = false;
        }
        if (u.right!=null && u.val>=right.min) {
            isBST = false;
        }
        int n = left.n + right.n + 1;
        if (isBST) {
            ans = Math.max(ans, n);
        }
        int min = Math.min(u.val, Math.min(left.min, right.min));
        int max = Math.max(u.val, Math.max(left.max, right.max));
        return new Result(isBST, min, max, n);
    }
    public int largestBSTSubtree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode u = new TreeNode(2);
        u.left = new TreeNode(1);
        TreeNode t = new TreeNode(2);
        t.left = u;
        System.out.println(s.largestBSTSubtree(u));
        System.out.println(s.largestBSTSubtree(t));
    }
}
