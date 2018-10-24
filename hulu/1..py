def _cmp(x,y):
    return x[0]>y[0] if x[0]!=y[0] else x[1]<y[1]
from collections import Counter
s = input().split(' ')
s = [x.lower() for x in s]
# print(s)
n = len(s)
t = Counter(s)
s = [(t[x],x) for x in t]
s.sort();


# s=sorted(s,cmp=_cmp)
s=s[::-1]
# print(s)
i=0;
while i+1<len(s) and s[i][0] == s[i+1][0]: i+=1
print(s[i][1])
    