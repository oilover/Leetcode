# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
def arrToList(a):
    dummy = ListNode(-1)
    p = dummy
    for x in a:
        p.next = ListNode(x)
        p = p.next
    return dummy.next
def listToArr(p: ListNode):
    a = []
    while p:
        a.append(p.val)
        p = p.next
    return  a
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right