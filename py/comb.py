class Solution:
    def combinationSum2(self, candidates, target: int):
        res = []
        candidates.sort()
        n = len(candidates)
        cur = []

        def dfs(begin: int, remain: int):
            if remain < 0: return
            if remain == 0: res.append(cur[:])
            for i in range(begin, n):
                if remain < candidates[i]: break
                if i > begin and candidates[i - 1] == candidates[i]:
                    continue
                cur.append(candidates[i]);
                dfs(i + 1, remain - candidates[i])
                cur.pop()

        dfs(0, target)
        return res;


s = Solution()
print(s.combinationSum2([10, 1, 2, 7, 6, 1, 5], 8))
