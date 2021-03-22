package com.hl;

import java.util.*;

class Node {
    int val;
    int color;
    public Node(int val) {
        this.val = val; color=0;
    }
    Node left, right;
}
class Solution {
    int res;
    int k;
    void dfs(Node u) {
        if (u==null) return;
        dfs(u.left);
        if (--k == 0) {
            res = u.val; return;
        }
        dfs(u.right);
    }
    int kthNode(Node root, int k) {
        this.k = k;
        if (root==null) return -1;
        res = -1;
//        dfs(root);
//        return res;
        Deque<Node> stack = new LinkedList<>();
//        stack.push(root);
        while (root!=null || !stack.isEmpty()) {
            while (root!=null ) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k==0) {
                return root.val;
            }
            root = root.right;
//            if (root.right!=null) stack.push(root.right);
//            if (u.color==0) {
//                if (u.left!=null) stack.push(u.left);
//                u.color = 1;
//                stack.push(u);
//                if (u.right!=null) stack.push(u.right);
//            } else {
//                if (--k==0) return u.val;
//            }
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node u = new Node(2);
        u.left = new Node(1);
        u.right = new Node(3);
        System.out.println(solution.kthNode(u, 3));
    }
}
