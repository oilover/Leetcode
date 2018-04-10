class Solution {
public:
    TreeNode* toBST(ListNode* head, int len) {
        if (head==NULL || len==0) return NULL;
        TreeNode t(head->val);
        if (head->next==NULL || len<=1) return &t;
        ListNode *slow = head, *fast = head;
        int left = 1, n = 1;
        while (fast->next!=NULL && n<len) {
            slow = slow->next; left++;
           
            if (fast->next!=NULL && n<len) fast = fast->next, n++;
            if (fast->next!=NULL && n<len) fast = fast->next, n++;
        }
        cout<<n<<endl;
        TreeNode rt = &TreeNode(slow->val);
        // rt.left = toBST(head, left-1);
        // rt.right = toBST(slow->next, n-left);
        return &rt;
    }
    TreeNode* sortedListToBST(ListNode* head) {
        return toBST(head, (int)1e8);
    }
};
