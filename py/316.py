class Solution:
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        n=len(s)
        ans=[]
        last={}
        first={}
        for i,c in enumerate(s):
            last[c]=i
            if not c in first:
                first[c]=i
        nxt = [{}]*(n+1)
        for i in range(n-1,-1,-1):
            nxt[i]=nxt[i+1].copy()
            nxt[i][s[i]] = i
            # print(i,':',nxt[i])
        # print(nxt)
        m = len(last)
        pos = 0
        for i in range(m):
            for c in sorted(last.keys()):
                if c in nxt[pos] and nxt[pos][c]<=min(last.values()):
                    # print(last,'pos:',nxt[pos][c],nxt[nxt[pos][c]])
                    ans.append(c)
                    last.pop(c, None)
                    pos = nxt[pos][c]
                    # print(last,'pos:',pos,nxt[pos])
                    break
        return ''.join(ans)

print( Solution().removeDuplicateLetters("cbacdcbc") )