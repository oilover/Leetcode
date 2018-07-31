from  queue import PriorityQueue
class Solution:
    """
    @param words: a list of words
    @return: a string which is correct order
    """
    def alienOrder(self, words):
        # Write your code here
        m = len(words)
        G = {}
        charset = set()
        indegree = {}
        for s in words:
            for ch in s:
                charset.add(ch);
                G[ch] = set()
                indegree[ch] = 0;
        for i in range(m-1):
            j=0
            min_len = min(len(words[i]), len(words[i+1]))
            while j<min_len:
                if (words[i][j]!=words[i+1][j]):
                    break;
                j+=1
            if j<min_len:
                G[words[i][j]].add(words[i+1][j])
                indegree[words[i+1][j]]+=1
        Q = PriorityQueue()
        ans = []
        for ch in indegree:
            if indegree[ch]==0:
                Q.put(ch)
        while not Q.empty():
            ch = Q.get() 
            # print(ch)
            ans.append(ch)
            for to in G[ch]:
                indegree[to]-=1
                if (indegree[to]==0):
                    Q.put(to)
        if len(ans)<len(charset): return ''
        return ''.join(ans)

s = Solution()
print (s.alienOrder(["wrt","wrf","er","ett","rftt"]))