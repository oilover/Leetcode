from collections import Counter
T = int(input())
while T> 0:
    n,m = map(int, input().split(' '))
    nbr = [set() for i in range(n+2)]
    Q =  [set() for i in range(n+2)]
    for i in range(m):
        u,v =  map(int, input().split(' '))
        nbr[u].add(v)
        nbr[v].add(u)
    ans = True
    t = set([x for x in range(1,n+1)])
    for i in range(1,n+1):
        Q[i]= t-nbr[i]
    vis = set()
    for i in range(1,n+1):
        if i in vis: continue;
        vis.add(i)
        for v in Q[i]:
            vis.add(v)
            if len(Q[v])!=len(Q[i]) :
                ans = False
                break;
            
            if Counter(Q[v])!=Counter(Q[i]):
                ans = False
                break;
        if not ans: break;
    print('Yes' if ans else 'No')
    T-=1

"""
2
5 7
1 3
1 5
2 3
2 5
3 4
4 5
3 5
4 3
1 2
2 3
3 4
样例输出
Yes
No

"""