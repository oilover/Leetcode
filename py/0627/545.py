# Definition for a binary tree node.
from typing import List
from random import randint

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def boundaryOfBinaryTree(self, root: TreeNode) -> List[int]:
        left, right = [], []
        leaves = []
        def dfs(u: TreeNode, isLeft, isRight):
            if not u: return
            isLeaf = u.left==None and u.right==None
            if isLeft and not isLeaf: left.append(u.val)
            if isLeaf: leaves.append(u.val)
            dfs(u.left, isLeft, isRight and not u.right and u!=root)
            dfs(u.right, isLeft and not u.left and u!=root, isRight)
            if isRight and not isLeaf and not isLeft: right.append(u.val)
        dfs(root, True, True)
        return left + leaves + right#[::-1]

s=Solution()
randint()
u = TreeNode(1)
u.right=TreeNode(3)
u.right.left=TreeNode(2)
u.right.right=TreeNode(4)
print(s.boundaryOfBinaryTree(u))
