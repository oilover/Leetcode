class Solution:
    def findRotateSteps(self, ring, key):
        """
        :type ring: str
        :type key: str
        :rtype: int
        """
        n,m = len(ring),len(key)
        dp = [[int(1e10)]*(n+1) for i in range(m+1)]
        dp[0][0] = 0
        left = [{} for i in range(n)]
        right = [{} for i in range(n)]
        pos = [{x:[]}]
        for i,x in enumerate(ring):
            if not x in pos:
                pos[x]=[]
            pos[x].append(i)
        for x in pos: pos[x].append(pos[x][0]+n)
        for i in range(n):
            if not x
            j=1
            left[i][ring[i]] = 0
            right[i][ring[i]]=0
            while ring[i-j]!=ring[i]:
                right[(i-j+n)%n][ring[i]] = j
                j+=1
            j=1
            while ring[(i+j)%n]!=ring[i]:
                left[(i+j)%n][ring[i]] = j
                j+=1
        for j in range(m):
            for i in range(n):
                p = pos[key[j]][bisect.bisect_left(pos[key[j]], key[j])]
                step = p-i #left[i][key[j]]
                pos = (i-step+n)%n
                dp[j+1][pos]=min(dp[j+1][pos], dp[j][i]+step+1)
                step = right[i][key[j]]
                pos = (i+step+n)%n
                dp[j+1][pos]=min(dp[j+1][pos], dp[j][i]+step+1)
        ans = int(1e10)
        for i in range(n): ans=min(ans, dp[m][i])
        return ans

print (Solution().findRotateSteps("abcde", "ade"))