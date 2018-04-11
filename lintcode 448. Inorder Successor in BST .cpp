/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

#define Node TreeNode
class Solution {
public:
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    stack<Node*> path;
    void getPath(Node* u, Node* p) {
        if (u==NULL) return;
        
        if (u==p) {
            
            return;
        }
        path.push(u);
        if (u->val > p->val) getPath(u->left, p);
        else getPath(u->right, p);
    }
    TreeNode * inorderSuccessor(TreeNode * root, TreeNode * p) {
        // write your code here
        if (p==NULL) return NULL;
        getPath(root, p);
        if (p->right) {
            Node* q = p->right;
            while (q->left) q=q->left;
            return q;
        }
        if (path.empty()) return NULL;
        Node *fa = path.top();
        if (fa->left == p) {
            return fa;
        }
        path.pop();
        while (fa->right == p && !path.empty()) {
            p = fa;
            fa = path.top(); path.pop();
        }
        // if (path.empty()) return NULL;
        if (fa->left==p) return fa;
        return NULL;
    }
};
