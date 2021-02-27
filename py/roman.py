class Solution:
    def intToRoman(self, num: int) -> str:
        chars = 'IVXLCDM'
        val = {}
        val[chars[0]] = 1
        n = len(chars)
        t = []
        for k,v in val.items():
            t.append([v,k])
        t.sort(reverse=True)
        print(t)
        res = ''
        i=0
        while num>0:
            t = num % 10
            num = num // 10
            if t==0: pass
            if t<=3:
                res = t*chars[i] + res
            if t==4:
                res = chars[i] + chars[i+1] + res
            if 5<=t and t<9: res = chars[i+1] + (t-5)*chars[i] + res
            if t==9: res = chars[i] + chars[i+2] + res
            i+=2

        return res

if __name__ == '__main__':
    s = Solution()
    print(s.intToRoman(9))
    print(s.intToRoman(19))