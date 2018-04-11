/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
#define Node ListNode
void prt(Node *p) {
    cout<<p->val<<endl;
}
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, Node *tail1, ListNode* l2, Node* tail2) {
        Node *p , *head=  new Node(-1);
        p =  head;
        while (l1!=tail1 || l2!=tail2) {
            Node *pp = new Node(-1);
            if (l1==tail1 || (l1!=tail1 && l2!=tail2 && l1->val > l2->val)) {
                pp = l2;
                l2 = l2->next;
            } else if (l1!=tail1) {
                pp = l1;
                l1 = l1->next;
            }
            p->next = pp;
            p = pp;
        }
        return head->next;
    }
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        return mergeTwoLists(l1, nullptr, l2, nullptr);        
    }
    ListNode* sortList(Node* head) { // [head, NULL)
        Node *slow,*fast;
        slow = fast = head;
        if (head==NULL || head==NULL) return NULL;
        if (head->next==NULL) return head;
        while (fast->next!=NULL && fast->next->next!=NULL) {
            slow=slow->next;
            fast = fast->next->next;
            // if (fast->next!=NULL) fast = fast->next;
        }
        fast = slow->next;
        slow->next = NULL;
        // cout<<"Fast: "; prt(fast);
        Node *l1 = sortList(head);
        Node *l2 = sortList(fast);
        return mergeTwoLists(l1, l2);
    }
    // ListNode* sortList(ListNode* head) {
    //     return sortList(head, nullptr);
    // }
};
