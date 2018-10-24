global pos, sumt, n
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
def Val(rt):
    return 0 if rt==None else rt.val
def build(pre, inorder):
    if len(pre)==0: return None
    i = 0
    for pos,x in enumerate(inorder): 
        if x==pre[0]:
            i = pos
    rt = TreeNode(pre[0])
    # print('rt:',Val(rt))
    rt.left = build(pre[1:i+1], inorder[:i])
    rt.right = build(pre[i+1:], inorder[i+1:])
    # print(rt.val, Val(rt.left), Val(rt.right))
    return rt

def solve(rt):
    if rt==None: return None
    l = Val(rt.left);
    r = Val(rt.right);
    u = TreeNode(l+r);
    u.left = solve(rt.left);
    u.right = solve(rt.right);
    t = Val(u.left) + Val(u.right)
    u.val += t
    # print(rt.val, t, u.val)
    return u;
def ino(rt):
    if rt==None: return []
    return ino(rt.left) + [str(rt.val)] + ino(rt.right)
pre = list(map(int, input().split(' ')))
inorder = list(map(int, input().split(' ')))
# print(pre)
n = len(pre)
pos = {}
for i,x in enumerate(inorder):
    pos[x] = i
sumt = [0] * n
rt = build(pre, inorder)
u = solve(rt)
# print('u:',Val(u), Val(rt))
print(' '.join(ino(u)))