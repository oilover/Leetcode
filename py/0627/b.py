from typing import List


class Solution:
    def findErrorNums(self, a: List[int]) -> List[int]:
        n = len(a)
        for i in range(n): a[i]-=1
        for i in range(n):
            if a[i]==i: continue
            while a[i]!=i and a[a[i]]!=a[i]:
                t = a[i]
                a[t] = a[i]
                a[i] = t
            if a[i]!=i:
                return [a[i]+1, i+1]

s = Solution()
print(s.findErrorNums([3,2,2]))