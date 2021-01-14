# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from common import *
class Codec:

    def dfs(_, u):
        if not u:
            _.res.append('^')
            return
        _.res.append(str(u.val))
        _.dfs(u.left);
        _.dfs(u.right);

    def serialize(_, u):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        _.res = []
        _.dfs(u)
        return '.'.join(_.res)

    def Dfs(_, data):
        _.i += 1
        # if i>=len(data): return None
        if (data[_.i] == '^'):
            return None
        u = TreeNode(int(data[_.i]))
        u.left = _.Dfs(data)
        u.right = _.Dfs(data)
        return u

    def deserialize(_, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        data = data.split('.')
        _.i = -1
        rt = _.Dfs(data)
        return rt

# Your Codec object will be instantiated and called as such:
u = TreeNode(1)
u.left = TreeNode(2)
ser = Codec()
deser = Codec()
ans = ser.serialize(u)
print(ans)
ans = deser.deserialize(ans)
print(ans.val)