class Solution:
    def reverseParentheses(self, s: str) -> str:
        s = [c for c in s]
        n = len(s)
        pair = [0]*n
        # print('n=',n)
        res = []
        cur = ''
        stk = []
        for ch in s:
            if ch=='(':
                stk.append(cur)
                cur = ''
            elif ch==')':
                cur = cur[::-1]
                cur = stk[-1] + cur
                stk.pop()
            else: cur = cur + ch
        # first = 0
        # while first<n:
        #     if s[first]!='(': first+=1
        #     else: first = dfs(s,first+1)
        return cur #''.join(filter(lambda c:c.isalpha(),s))

s = Solution()
print(s.reverseParentheses("f(ul)ao(t(y)qbn)()sj"))
print(s.reverseParentheses("(ab(cd))"))
print(s.reverseParentheses("co(de(fight)s)"))
print(s.reverseParentheses("(ed(et(oc))el)"))
print(s.reverseParentheses("(abcd)"))
print(s.reverseParentheses("(u(love)i)"))