package target_sum;

import tree.TreeNode;

class Solution {
    public int findTargetSumWays(int[] a, int target) {
        int sum = 0;
        for (int x: a) {
            sum+=x;
        }
        int n = a.length;
        int[][] dp = new int[n+1][2*sum+1];
        dp[0][sum] = 1;
        for (int i=1;i<=n;i++) {
            int x = a[i-1];
            for (int j = 0; j <= 2*sum; j++) {
                if (j>=x) {
                    dp[i][j] += dp[i-1][j-a[i-1]];
                }
                if (j+x<=2*sum) {
                    dp[i][j] += dp[i-1][j+x];
                }
            }
        }
        return dp[n][target+sum];
    }
    private TreeNode ans, parent;
//    TreeNode dfs(TreeNode u, int key) {
//
//    }
    TreeNode predecessor(TreeNode u) {
        if (u==null || u.left==null) {
            return null;
        }
        TreeNode v = u.left;
        while (v.right!=null) {
            v = v.right;
        }
        return v;
    }
    TreeNode sucessor(TreeNode u) {
        if (u==null || u.right==null) {
            return null;
        }
        TreeNode v = u.right;
        while (v.left!=null) {
            v = v.left;
        }
        return v;
    }
    public TreeNode deleteNode(TreeNode u, int key) {
        parent = null;
        if (u==null) {
            return null;
        }
        parent = u;
        if (key < u.val) {
            return deleteNode(u.left, key);
        }
        if (u.val < key) {
            return deleteNode(u.right, key);
        }
        if (u.left == null) {
            return u.right;
        }
        if (u.right == null) {
            return u.left;
        }
        u.val = sucessor(u).val;
        u.right = deleteNode(u.right, u.val);
        return u;
//        TreeNode v = u.left;
//        while (v!=null) {
//            v = v.right;
//        }
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode u = new TreeNode(5);
        System.out.println(s.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
        System.out.println(s.findTargetSumWays(new int[]{1,1,1,1,1}, 5));
    }
}
