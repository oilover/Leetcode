class Solution:
    def expr(self, exp):
        exp += '+'
        stack = []
        num = 0
        operator = '+'
        for ch in exp:
            if ch.isdigit():
                num = num * 10 + int(ch)
            if ch in '+-*/':
                if operator == '+':
                    stack.append(num)
                elif operator == '-':
                    stack.append(-num)
                elif operator == '*':
                    stack[-1] *= num
                elif operator == '/':
                    stack[-1] /= num
                operator = ch
                num = 0
        return sum(stack)

s = Solution()
print(s.expr('-3+2'))
print(s.expr('3+20 - 8'))
print(s.expr('3 + 2*7'))
print(s.expr('32'))
