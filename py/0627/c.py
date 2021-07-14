from typing import List

class Solution:
    def countGoodNumbers(self, n: int) -> int:
        mod = int(1e9+7)
        def pow(a,n):
            res =1
            while n>0:
                if n%2==1: res=res*a%mod
                a=a*a%mod
                # print (n,a,res)
                n//=2
            return res
        x = pow(5,(n+1)//2)
        y = pow(4,n//2)
        # print (x,y)
        return x*y%mod

s = Solution()
print(s.countGoodNumbers(1))
print(s.countGoodNumbers(4))
print(s.countGoodNumbers(50))
# print(s.eliminateMaximum([1,3,4],[1,1,1]))    
# print(s.eliminateMaximum(dist = [1,1,2,3], speed = [1,1,1,1]))    
# print(s.eliminateMaximum(dist = [1,1,2,3], speed = [1,1,1,1]))    