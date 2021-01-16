class Solution:
    def intToRoman(self, num: int) -> str:
        chars = 'IVXLCDM'
        val = {}
        val[chars[0]] = 1
        n = len(chars)
        # for i,x in enumerate(chars):
        #     if i==0: continue
        #     if i%2==0:
        #         val[x] = val[chars[i-1]] * 2
        #     else:
        #         val[x] = val[chars[i-1]] * 5
        # for i,x in enumerate(chars):
        #     if i%2>0: continue
        #     if (i+1<n):
        #         val[x+chars[i+1]] = val[chars[i+1]] - val[x]
        #     if (i+2<n):
        #         val[x+chars[i+2]] = val[chars[i+2]] - val[x]
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
            if t==5: res = chars[i+1] + res
            if 6<=t and t<9: res = chars[i+1] + (t-5)*chars[i] + res
            if t==9: res = chars[i] + chars[i+2] + res
            i+=2
        # for k,v in t:
        #     t = num // k
        #     num %= k
        #     res += t*v
            # while num>=k:
            #     num-=k

        return res

if __name__ == '__main__':
    s = Solution()
    print(s.intToRoman(9))
    print(s.intToRoman(19))