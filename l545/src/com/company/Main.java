package com.company;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public 
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    List<Integer> ans;
    Stack<Integer> stack;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ans = new ArrayList<Integer>();
        stack = new Stack<>();
        dfs(root, 0);
        while (!stack.empty()) {
            ans.add(stack.pop());
        }
        return  ans;
    }
/*flag = 0：根节点
flag = 1：左边界节点
flag = 2：右边界节点
flag = 3 ：其它（中间节点）
 */
    private void dfs(TreeNode u, int t) {
        if (u == null) return;
        int tt;
        // 如果是左边界或者叶子，加入答案（右边届要倒序
        if (t<2 || (t==3&&u.left==null&&u.right==null)) {
            ans.add(u.val);
        }
        if (t==2) {
            stack.push(u.val);
        }
        switch (t) {
            case 0:     // 根节点
                dfs(u.left, t>=2 ? 3 : 1);
                dfs(u.right, 2);
                break;
            case 1:     //左边界节点
                dfs(u.left, t>=2 ? 3 : 1);
                dfs(u.right, u.left == null ? 1 : 3);
                break;
            case 2:  // 右边届
                dfs(u.left, u.right==null ? 2 : 3);
                dfs(u.right, 2);
                break;
            default:
                dfs(u.left, 3);dfs(u.right,3);
        }
    }
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        Solution s = new Solution();
        TreeNode u = new TreeNode(2);
        u.left = new TreeNode(3); u.right = new TreeNode(4);
        TreeNode r = new TreeNode(1);
        r.right = u;
        System.out.println(s.boundaryOfBinaryTree(r));
    }
}
