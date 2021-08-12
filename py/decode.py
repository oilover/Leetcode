class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        cnt, res = 0, ''
        for ch in s:
            if ch>='0' and ch<='9':
                cnt = cnt*10+(int)(ch)
                continue
            if ch=='[':
                stack.append([cnt,res])
                cnt = 0
                res = ''
                continue
            if ch==']':
                last_cnt, last_res = stack.pop()
                res = last_res + last_cnt*res
                continue
            res += ch
        return res

for p, w in enumerate(["Thousand", "Million", "Billion"], 2):
    print(p,w)
s = Solution()
print(s.decodeString("3[a]2[bc]"))      
print(s.decodeString("3[a2[c]]"))
print(s.decodeString("2[abc]3[cd]ef"))
print(s.decodeString("asdf"))
print(s.decodeString("asd[]"))