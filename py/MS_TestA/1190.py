class Solution:
    def reverseParentheses(self, s: str) -> str:
        s = [c for c in s]
        n = len(s)
        def dfs(s, start):
            end = start
            while end<n and s[end]!=')':
                if s[end]=='(': end=dfs(s,end+1)
                end+=1
            i,j = start, end-1
            while i<j:
                if s[i]!='(':
                    s[i],s[j]=s[j],s[i]
                i+=1
                j-=1
            return end+1
        first = 0
        while first<n and s[first]!='(': first+=1
        dfs(s,first+1)
        return ''.join(filter(lambda c:c.isalpha(),s))

s = Solution()
print(s.reverseParentheses("(ab(cd))"))
print(s.reverseParentheses("(ed(et(oc))el)"))
print(s.reverseParentheses("(abcd)"))
print(s.reverseParentheses("(u(love)i)"))