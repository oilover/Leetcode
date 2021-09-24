# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
def getH(node):
    if not node: return 0
    return getH(node.left)+1
def getNode(root, parent, dir, h, i):
    if h<0 or not root: return (root, parent, dir)
    if i&(1<<h)==0: return getNode(root.left, root, 0, h-1,i)
    return getNode(root.right,root, 1, h-1,i)
def insert(root, node):
    h = getH(root)
    r = 2**(h-1)-1
    l=0
    while l<r:
        mid=l+(r-l)//2
        u, parent, dir = getNode(root, h-2, mid)
        if not u:
            r = mid
        else:
            l=mid+1
    if dir==0:
        parent.left = node
    else:
        parent.right = node
    x=1
def print_hi(name):
    # Use a breakpoint in the code line below to debug your script.
    print(f'Hi, {name}')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    u = TreeNode(1)
    insert(u,TreeNode(2))
    print_hi('PyCharm')

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
