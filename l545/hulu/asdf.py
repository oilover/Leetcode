import sys
from math import sqrt
def gcd(a,b):
    return a if b==0 else gcd(b,a%b)
def OK(x):
    t = int(sqrt(x+0.3))
    # return t
    return t if t*t==x else int(1e18)
for line in sys.stdin:

    N = int(line)
    # prime = [True]*(N+1)
    # prime[1] = False
    # for i in range(2,N):
    #     if not prime[i]: continue
    #     for j in range(i+i,N,i):
    #         prime[j] = False
    cnt = 0
    for a in range(2,N):
        # if prime[a]:
        for b in range(a+1,N):
            if not gcd(a,b)==1: continue
            # print(a,b)
            t = OK(a*a+b*b)
            if t<=N and gcd(t,a)==1 and gcd(t,b)==1: 
                cnt+=1
                # print(a,b,t)
    print(cnt)