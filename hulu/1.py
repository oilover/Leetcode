import sys
from math import sqrt
def gcd(a,b):
    return a if b==0 else gcd(b, a%b)

def lcm(a,b):
    return a//gcd(a,b)*b

def isP(n):
    m = int(sqrt(n+0.5))
    for i in range(2,m+1):
        if n%i==0: return False
    return True
def Lcm(n):
    t = 1
    for i in range(1,n+1): t=lcm(t,i)
    return t
for line in sys.stdin:
    n = int(line)
    if n==1: 
        print(2)
        continue
    for i in range(n,0,-1):
        if isP(i):
            print(2*i)
            break