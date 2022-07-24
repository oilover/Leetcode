package b;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int i) {
        val = i;
    }
}

class Solution {
    boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isBST(TreeNode root, int low, int high) {
        if (root == null) {
            return true;
        }
        if (root.val < low || root.val > high) {
            return false;
        }
        return isBST(root.left, low, root.val) && isBST(root.right, root.val, high);
    }

    long maxMulti(int[] a) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        long res = Integer.MIN_VALUE;
        for (int x : a) {
            int tMax, tMin;
            if (x >= 0) {
                tMax = Math.max(max * x, x);
                tMin = Math.min(min * x, x);
            } else {
                tMax = Math.max(min * x, x);
                tMin = Math.min(max * x, x);
            }
            max = tMax;
            min = tMin;
            res = Math.max(max, res);
        }
        return res;
    }

}

public class Main {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        TreeNode u = new TreeNode(2);
        u.left = new TreeNode(0);
        u.right = new TreeNode(3);
//        System.out.println(sol.isBST(u));
//        System.out.println(sol.maxMulti(new int[]{-1,-3,-2}));
    }
}

