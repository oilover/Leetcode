
def dfs(x,y):
    global a,n,m,cnt
    vis[x][y]=True
    cnt+=1
    for d in range(8):
        xx = x + dir[d][0]
        yy = y + dir[d][1]
        if 0<=xx and xx<n and 0<=yy and yy<m and not vis[xx][yy] and a[xx][yy]==1:
            dfs(xx,yy)
    return cnt

dir = ((0,1),(1,0),(0,-1),(-1,0), (1,-1),(1,1),(-1,1),(-1,-1))
line = input()
global a,n,m,cnt
n,m = [int(x) for x in line.split(',')]
a = [[] for i in range(n)]
for i in range(n):
    line=input()
    a[i]  = [int(x) for x in line.split(',')]
global vis
vis = [[False]*m for i in range(n)]
Q=  0
tot = 0
for i in range(n):
    for j in range(m):
        if vis[i][j] or a[i][j]==0: continue
        cnt = 0
        dfs(i,j)
        Q = max(Q, cnt)
        tot += 1
print (str(tot)+','+str(Q))