from queue import Queue
from collections import deque
from typing import List


class Solution:
    def calculate(self, s: str) -> int:
        s = s.strip()

        def helper(q: deque) -> int:
            sign = '+'
            stack = []
            num, res = 0, 0
            op = {'+': 1, '-': 1, '*': 2, '/': 2}
            while not q.empty():
                c = q.popleft()
                if c.isdigit():
                    num = num * 10 + int(c)
                    # continue
                if c == ' ': continue
                if c == '(':
                    num = helper(q)
                if not c.isdigit() or q.empty():
                    if sign == '+':
                        stack.append(num)
                    elif sign == '-':
                        stack.append(-num)
                    elif sign == '*':
                        pre = stack.pop()
                        stack.append(pre * num)
                    elif sign == '/':
                        stack[-1] = int(stack[-1] / float(num))
                    sign = c
                    num = 0
                if c == ')': break
            return sum(stack)

        q = Queue()
        for c in s: q.put(c)
        return helper(q)


s = Solution()
print(s.calculate('3/2'))
print(s.calculate(' 3/2 '))
print(s.calculate('3 / 2'))
print(s.calculate('2+4'))
print(s.calculate('2+2*(3+7)+6'))
