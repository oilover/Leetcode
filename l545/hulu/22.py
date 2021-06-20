import queue
leaf = []
class TreeNode:
    def __init__(self, x, l, r):
        self.val = x
        self.l = l
        self.r = r
        self.left = None
        self.right = None
def getval(p):
    return '#' if p==None else p.val
def preorder(rt, res):
    if rt==None: return
    global leaf
    res.append(rt.val)
    # print(rt.val, getval(rt.left), getval(rt.right))
    if rt.left==None and rt.right==None:
        leaf.append(rt.val)
    preorder(rt.left, res)
    preorder(rt.right, res)
def post(rt, res):
    if rt==None: return
    post(rt.left, res)
    post(rt.right, res)
    res.append(rt.val)
level = {}
pos = {}
s = input().split(' ')
n = len(s)
inorder = input().split(' ')

for i,x in enumerate(inorder): pos[x] = i
# print(pos)
cur = 0
rt = TreeNode(s[0],0, n)
level[s[0]] = 0
p = rt
Q = queue.Queue()
Q.put(rt)
i = 1
while i<n and not Q.empty():
    p = Q.get()
    t = p.val
    x = s[i]
    if not (p.l<=pos[x] and pos[x]<p.r):
        continue
    if pos[x] < pos[t]: 
        p.left = TreeNode(x, p.l, pos[t])
        Q.put(p.left)
        i+=1
    else:
        p.right = TreeNode(x, pos[t]+1, p.r)
        Q.put(p.right)
        i+=1
        continue
    if i>=n: break
    y = s[i]
    if pos[y] > pos[t] and p.l<=pos[y] and pos[y] < p.r:
        p.right = TreeNode(y, pos[t]+1, p.r)
        Q.put(p.right)
        i+=1

pre, post_ = [], []
preorder(rt, pre)
post(rt, post_)
print(' '.join(leaf))
print(' '.join(pre))
print(' '.join(post_))
