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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        if (root==NULL) return result;
        Node *pre=nullptr, *cur = root;
        while (cur!=NULL) {
            if (cur->left == NULL) {
                result.push_back(cur->val);
                pre = cur;
                cur = cur->right;
            } else {
                Node *u = cur->left;
                while (u->right!=nullptr && u->right!=cur) {
                    u=  u->right;
                }
                if (u->right == nullptr) {
                    u->right = cur;
                    result.push_back(cur->val);
                    pre = cur;
                    cur = cur->left;
                } else {
                    u->right = nullptr;
                    cur = cur->right;
                }
            }
        }
        return result;
    }
};
