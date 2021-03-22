package tree;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 Definition for a binary tree node.
 */

public class Solution {
    Node print(Node u) {
        if (u==null) {
            return null;
        }
        System.out.print(u.val+" ");
        if (u.right==null) {
            return u;
        }
        return print(u.right);
    }
    Node rprint(Node u) {
        if (u==null) {
            return null;
        }
        System.out.print(u.val+" ");
        if (u.left==null) {
            return u;
        }
        return rprint(u.left);
    }
    private Node last,head;
    Node dfs(Node u) {
        if (u==null) return null;
        Node pre = last;
        last = u;
        Node l = dfs(u.left);
        if (l!=null) l.left = u;
        Node t = last;
        Node r = dfs(u.right);
        u.left = pre; //last; 这样是循环列表
        u.right = l==null ? r : l;
        if (r!=null) r.left = t;
        t.right = r;
        return u;
    }
    void Dfs(Node u) { // 中序遍历转链表
        if (u==null) return ;
        Dfs(u.left);
        if (last!=null) {
            last.right = u;
            u.left = last;
        }else{
            head = u;
        }
        last = u;
        Dfs(u.right);

        return ;
    }
    Node toList(Node u) {
        last = head = null;
        return dfs(u);
    }
    Node midToList(Node u) {
        last = head = null;
        Dfs(u);
        return head;
    }

    public static void main(String[] args) {
        Node u = new Node(1);
//        u.left = new TreeNode(2);
//        u.left.left = new TreeNode(3);
//        u.left.right = new TreeNode(4);
//        u.right = new TreeNode(5);
//        u.right.right = new TreeNode(6);
//        u.right.right.left = new TreeNode(8);

        u.left = new Node(2);
//        u.right = new TreeNode(2);
        Solution s = new Solution();
        u = s.midToList(u);
        Node t = s.print(u);
        System.out.println();
        s.rprint(t);
    }
}
