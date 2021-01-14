s = input()
n, tar = [int(x) for x in s.split(' ') ]
G=[set() for i in range(n)]
for i in range(n):
    s = input()
    G[i] = set([int(x) for x in s.split(' ')])
if n==1:
    print(-1)
    exit(0)
ans, ma=-1,0
t =[ (-len(G[tar] & G[i]),i) for i in range(n) if i!=tar and not i in G[tar]]
if len(t)==0:
    print(-1)
    exit(0)
t = min(t)
ans = t[1]
if t[0]==0: ans=-1
print (ans)
# for i in G[tar]:

#     cnt= len(G[tar] & G[i])
#     for j in G[i]:
        
#         if j in G[tar]: continue5 0
