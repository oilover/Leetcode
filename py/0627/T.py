# //32281228 三千两百万七十八
val = {'零': 0, '一': 1, '二': 2, '两': 2, '三': 3, '四': 4, '五': 5, '六': 6, '七': 7, '八': 8, '九': 9}
unit = {'十': 10, '百': 100, '千': 1000, '万': 10000, '亿': 100000000}


class Solution:
    def atoi(self, s: str):
        def deal(s): # 处理1万以下的数
            pre = 1
            res = 0
            if len(s) == 0: return 0
            for c in s:
                if c in unit:
                    res += pre*unit[c]
                else:
                    pre=val[c]
            if s[-1] in val: res += pre
            # print(s,res)
            return res
        yiPos = s.find('亿')
        wanPos = s.find('万')
        yiStr = '' if yiPos==-1 else s[:yiPos]
        wanStr = '' if wanPos==-1 else s[yiPos+1:wanPos]
        geStr = s
        if wanPos>=0: geStr = s[wanPos+1:]
        else:
            if yiPos>=0: geStr = s[yiPos+1:]
        # print(yiPos,wanPos)
        return deal(yiStr)*int(1e8) + deal(wanStr)*int(1e4) + deal(geStr)
    def atoi2(self, s):
        res = 0
        num = 1
        pre = ''
        tmp = 0
        for c in s:
            if c in unit:
                # if c == '亿':
                #     tmp = (res+num) * unit[c]
                #     res = 0;
                # else:
                if pre in unit:
                    res *= unit[c]
                else:
                    res += num * unit[c]
            else:
                num = val[c]
            pre = c
        if s[-1] in val: res += num
        return res + tmp
    def f(self,s):
        print(self.atoi(s), self.atoi2(s))

s = Solution()
(s.f('三亿零七'))
(s.f('两亿三千万零四百'))
(s.f('三千零七'))
(s.f('三千两百七十八万零七十八'))
s.f('九千九百九十九万九十九')
print(s.atoi('一十七'))
print(s.atoi('一千万两千一百八十一'))
print(s.atoi('三万亿'))
print(s.atoi('三亿亿'))
# print('Hello world - Python 3!')
