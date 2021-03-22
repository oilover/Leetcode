from typing import List
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        n,m = len(s), len(wordDict)
        dp = [[]]
        for i in range(1,n+1):
            dp.append([])
            for j,word in enumerate(wordDict):
                pre = i-len(word)
                if pre<0: continue
                if (pre==0 or len(dp[pre])>0) and s[pre:i]==word:
                    dp[i].append(word)
        res = []
        cur = []
        def dfs(i):
            if i==0:
                res.append(' '.join(cur[::-1]))
                return
            for word in dp[i]:
                cur.append(word)
                dfs(i-len(word))
                cur.pop()
        dfs(n)
        return res

s = Solution()
print(s.wordBreak("catsanddog",
["cat","cats","and","sand","dog"]))