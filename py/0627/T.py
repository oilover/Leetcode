# //32281228 三千两百万七十八
val = {'零': 0, '一': 1, '二': 2, '两': 2, '三': 3, '四': 4, '五': 5, '六': 6, '七': 7, '八': 8, '九': 9}
unit = {'十': 10, '百': 100, '千': 1000, '万': 10000, '亿': 100000000}


class Solution:
    def atoi(self, s: str):
        res = 0
        num = 1
        if len(s) == 0: return 0
        pre = ''
        tmp = 0
        for c in s:
            if c in unit:
                if c == '亿':
                    tmp = (res+num) * unit[c]
                    res = 0;
                else:
                    if pre in unit:
                        res *= unit[c]
                    else:
                        res += num * unit[c]
            else:
                num = val[c]
            pre = c
        if s[-1] in val: res += num
        return res + tmp


s = Solution()
print(s.atoi('两亿三千万零四百'))
print(s.atoi('三千零七'))
print(s.atoi('一十七'))
print(s.atoi('三千两百万零七十八'))
print(s.atoi('一千万两千一百八十一'))
print(s.atoi('三万亿'))
print(s.atoi('三亿亿'))
# print('Hello world - Python 3!')
