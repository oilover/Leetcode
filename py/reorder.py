# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from common import *
class Solution:
    def rev(self, p: ListNode) -> ListNode:
        if not p or not p.next: return p
        nxt = p.next
        t = self.rev(p.next);
        nxt.next = p
        p.next = None
        return t


    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head or not head.next: return
        s, f = head, head
        while f.next and f.next.next:
            # pre = s
            s, f = s.next, f.next.next
        pre = s
        s = s.next
        pre.next = None
        s = self.rev(s)
        p = head
        while p and s:
            t1,t2  = p.next, s.next
            if s: s.next = p.next
            p.next = s
            p = t1
            s = t2

if __name__ == '__main__':
    s = Solution()
    t = arrToList([1,2,3,4,5])
    s.reorderList(t)
    print(listToArr(t))