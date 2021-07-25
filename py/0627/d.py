# a = [[3,2],[1]]
# a.sort(key=lambda x:len(x))
# print(a)
class Solution:
    def getLucky(self, s: str, k: int) -> int:
        def f1(s):
            res = []
            for ch in s:
                if ch.isalpha():
                    res.append(str(ord(ch)-96))
            return ''.join(res)
        def f(s):
            return str(sum([int(x) for x in s]))
        s = f1(s)
        for i in range(k):
            s = f(s)
        return int(s)
            
s=Solution()
print(s.getLucky(s = "iiii", k = 1))
print(s.getLucky(s = "leetcode", k = 2))