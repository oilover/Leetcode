class TreeNode:
    def __init__(self, v):
        self.left = None
        self.right = None
        self.val = v

class Solution:
    def RightNodesSum(self, root: TreeNode):
        def isLeaf(p: TreeNode):
            return p and not p.left and not p.right

        def dfs(u: TreeNode):
            if not u: return 0
            rSum = dfs(u.left) + dfs(u.right)
            if isLeaf(u.right):
                rSum += u.right.val
            return rSum

        return dfs(root)
        # return self.res


solution = Solution()
u = TreeNode(1)
print(solution.RightNodesSum(None))
print(solution.RightNodesSum(u))
u.right = TreeNode(3)
print(solution.RightNodesSum(u))
u.left = TreeNode(2)
u.right.left = TreeNode(5)
u.right.left.right = TreeNode(15)
print(solution.RightNodesSum(u))
u.left.left = TreeNode(9)
u.left.right = TreeNode(10)
print(solution.RightNodesSum(u))
