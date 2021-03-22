package tree.travel;

import tree.TreeNode;
import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {

    List<Integer> preorder(TreeNode u) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        s.push(u);
        while (u!=null && !s.isEmpty()) {
            u = s.pop();
            res.add(u.val);
            if (u.right!=null) s.push(u.right);
            if (u.left!=null) s.push(u.left);
        }
        return res;
    }
    List<Integer> inorder(TreeNode u) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (u != null || !s.isEmpty()) {
            while (u!=null ) {
                s.push(u);
                u = u.left;
            }
            u = s.pop();
            res.add(u.val);
            u = u.right;
        }
        return res;
    }
    List<Integer> postorder(TreeNode u) {
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> res = new Stack<Integer>();
        s.push(u);
        while (u!=null && !s.isEmpty()) {
            u = s.pop();
            res.add(u.val);
            if (u.left!=null) s.push(u.left);
            if (u.right!=null) s.push(u.right);
        }
        return res;
    }
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        int res[][] = new int[8][3];
        return res;
    }
}