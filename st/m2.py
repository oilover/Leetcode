def get():
    return input().split('=')[1]
def f(s): return s[1:-1]
ans = []
def gao(s, d, res):
    global ans
    if s=='': 
        ans.append(' '.join(res))
        return
    for ss in d:
        n = len(ss)
        if s[:n]==ss:
            # t = res.copy() + [ss] # 
            res.append(ss)
            gao(s[n:], d, res)
            res.pop()
            # res = res[:-1]

s = f(get()) # input()
d = set( list(map(f, get().split(','))) )#
# s =  input()
# d = set(input().split(','))
# print(s,d)
res = []
gao(s,d,res)
# ans = '[' + ', '.join(ans) + ']'
print(ans)