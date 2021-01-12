# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def rev(self, p: ListNode) -> ListNode:
        if not p or not p.next: return p
        nxt = p.next
        t = self.rev(p.next);
        nxt.next = p
        p.next = None
        return t

    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        i = 0
        dummy = ListNode(-1);
        dummy.next = head;
        p = dummy
        while i < n:
            if i == m - 1: pre = p
            i += 1
            p = p.next
        next = p.next # 第m+1节点
        p.next = None
        tmp = pre.next # 翻转部分翻转后的最后节点
        t = self.rev(pre.next); # 翻转部分的头
        pre.next = t
        tmp.next = next
        return dummy.next

def arrToList(a):
    dummy = ListNode(-1)
    p = dummy
    for x in a:
        p.next = ListNode(x)
        p = p.next
    return dummy.next
s = Solution()
p = arrToList([1,2,3,4,5])
# p = s.rev(p)
s.reverseBetween(p,2,4)
