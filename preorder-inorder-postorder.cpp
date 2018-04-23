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

#define Node TreeNode
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
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
                    
                    cur = cur->left;
                } else {
                    u->right = nullptr;
                    result.push_back(cur->val);
                    pre = cur;
                    cur = cur->right;
                }
            }
        }
        return result;
    }
};

/**
 */
#define Node TreeNode
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<Node*> S;
        Node *p = root, *pre=NULL; //pre: 刚刚访问过的点
        do {
            while (p!=NULL) {
                S.push(p);
                p=p->left;
            }
            pre = NULL;
            while (!S.empty()) {
                p = S.top(); S.pop();
                if (p->right == pre) { 
                    result.push_back(p->val);
                    pre = p;
                } else {
                    S.push(p); 
                    p = p->right;
                    break;
                }
            }
        } while (!S.empty());
        return result;
    }
};
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        if (root==NULL) return result;
        Node *pre=nullptr, *cur = root;
        stack<Node*> S;
        while (!S.empty() || cur) {
            if (cur==NULL) {
                cur = S.top(); S.pop();
                result.push_back(cur->val);
                cur = cur->right;
            } else {
                S.push(cur);
                cur = cur->left;
            }
        }
        return result;
    }
};
class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> result;
        if (root==NULL) return result;
        Node *pre=nullptr, *cur = root;
        stack<Node*> S; S.push(root);
        while (!S.empty()) {
            cur=  S.top(); S.pop();
            result.push_back(cur->val);
            if (cur->right) S.push(cur->right);
            if (cur->left) S.push(cur->left);
        }
        return result;
    }
};
