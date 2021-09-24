INT_MAX = (2 ** 31) - 1


class Solution:
    def atoi(self, s):
        s = s.rstrip()
        start = 0
        if len(s) == 0: return None
        n = len(s)
        while start < n and s[start] == ' ': start += 1
        if start >= n: return None
        sign = 1
        if s[start] in '+-':
            if s[start] == '-': sign = -1
            start += 1
        res = 0
        for i in range(start, n):
            digit = s[i]
            if not digit.isdigit(): return None
            digit = int(digit)
            if sign == 1:
                if res > (INT_MAX - digit) // 10: return None
            else:  # 负数
                if res > (INT_MAX + 1 - digit) // 10: return None
            res = res * 10 + digit
        return sign * res


s = Solution()
print(s.atoi(''))
print(s.atoi('   12d37'))
print(s.atoi('+123a'))
print(s.atoi('+-123'))
print(s.atoi('   123 7   '))
print(s.atoi('+2147483648'))
print(s.atoi('+2147483647'))
print(s.atoi('-2147483648'))
print(s.atoi('+123866432222'))
