/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode *first, *second, *prev;
    void recoverTree(TreeNode* root) {
        first = second = prev = NULL;
        dfs(root);
        if (first && second) swap(first->val, second->val);
    }
    void dfs(TreeNode* rt) {
        if (rt == NULL) return ;
        dfs(rt->left);
        if (prev!=NULL && prev->val > rt->val) {
            if (first==NULL) {
                first = prev; second = rt;
            } else {
                second = rt;
            }
        }
        prev = rt;
        dfs(rt->right);
    }
};
