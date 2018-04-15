/*
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
	TreeNode(int x) :
			val(x), left(NULL), right(NULL) {
	}
};*/
#define Node TreeNode
#define MP make_pair
class Solution {
public:
    pair<Node*, Node*> dfs(Node *u) {
        if (u==NULL) return MP(u,u);
        auto l = NULL;
        Node *head = u, *tail = u;
        if (u->left != NULL) {
            auto l = dfs(u->left);
            l.second->right = u;
            u->left = l.second;
            head = l.first;
        } else {
            ;
        }
        if (u->right != NULL) {
            auto l = dfs(u->right);
            l.first->left = u;
            u->right = l.first;
            tail = l.second;
        }
        return make_pair(head, tail);
    }
    TreeNode* Convert(TreeNode* root)
    {
        auto t = dfs(root);
        return t.first;
    }
};
