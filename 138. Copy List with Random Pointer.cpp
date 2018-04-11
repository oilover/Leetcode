/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
#define Node RandomListNode
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if (head==0) return NULL;
        RandomListNode *p = head;
        for (;p;) {
            RandomListNode *p1 = new RandomListNode(p->label);
            p1->next = p->next;
            p->next = p1;
            p = p1->next;
        }
        p = head;
        for (;p;) {
            if (p->next && p->random) p->next->random = p->random->next;
            if (p) p=p->next;
            if (p) p=p->next;
        }
        Node *new_head = head->next;
        p = head;
        for (;p;) {
            Node *nxt = p;
            if (nxt) nxt=nxt->next;
            if (nxt) nxt=nxt->next;
            if (nxt && p->next) p->next->next = nxt->next;
            p->next = nxt;
            p = nxt;
        }
        return new_head;
    }
};
