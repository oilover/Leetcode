from bisect import bisect_left, bisect_right
global n,a,b
n=int(input())
a = []
for i in range(n):
    line=input()
    t = line.split(';')
    seg = [list([int(x) for x in line.split(',')]) for line in t]
    a=a+seg
a = list(a)
# print(a, type(a[0]))
for x in a:
    t = x[0]
    x[0] = x[1]
    x[1] = t
a.sort()
b = []
for i in range(len(a)):
    l = a[i][1]
    j=  bisect.bisect_left(b,(l,0))
    for k in range(j,len(b)):
        l=min(l,b[k][1])
    b = b[:j]
    b.append((a[i][0],l))
ans = []
# b=  list(b)
# for x in b:
#     t = x[0]
#     x[0] = x[1]
#     x[1] = t
for x in b:
    ans.append(str(x[1])+','+str(x[0]))
print(';'.join(ans))