
def count1(n):
    ans = 0
    while n>0:
        if n%10==1: ans+=1
        n//=10
    return ans
def num1(n):
    res = 0
    for i in range(n+1): res+=count1(i)
    return res
def solve(num):
    low = 1
    high = num//10
    n = num
    res = 0
    while n>0:
        t = (high+1)*low
        if n%10==0: t = high*low
        if n%10==1: t = high*low + num%low + 1
        # if n%10>1:  t = (high+1)*low
        res += t
        high //= 10
        low *= 10
        n//=10
    return res

print(num1(114), num1(124), solve(124))