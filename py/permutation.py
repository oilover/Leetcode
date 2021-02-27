class Solution:
    def check(self, s:str, res):
        s = sorted(s)
        for x in res:
            if s!=sorted(x): return False
        return len(set(res)),len(res)
    def permutation(self, s: str) :
        c, res = list(s), []
        c.sort()
        used = [False] * len(c)
        cur = []
        def dfs(x):
            if x == len(c):
                res.append(''.join(cur)) # 添加排列方案
                return
            dic = set()
            for i in range(len(c)):
                if used[i]: continue
                if  (i>0 and c[i]==c[i-1] and not used[i-1]): continue # 重复，因此剪枝
                used[i] = True
                cur.append(c[i])
                dfs(x + 1) # 开启固定第 x + 1 位字符
                cur.pop()
                used[i] = False
        dfs(0)
        return res

s = Solution()
res = s.permutation("suvyls")
print(s.check("suvyls", res))

