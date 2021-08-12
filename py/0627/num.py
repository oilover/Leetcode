#Convert an int32 input to Chinese oral expression, for example:
#123->YiBaiErShiSan
#10000->YiWan
#10001->YiWanLingYi
# 135605000 YiYiSanQianWuBaiLiuShiWanWuQian
# -10 FuShi

def posnum2chinese(n): 
    digit = {0: 'Ling',1:'Yi',2:'Er', 3:'San', 4:'Si', 5:'Wu',6:'Liu',7:'Qi',8:'Ba', 9:''}
    res = ''
    if n==0: return 'Ling'
    zero = False
    i = 0
    unit = {0:'', 1: 'Shi', 2: 'Bai', 3:'Qian',}
    def deal(n): # 处理处理处理1wan
        res = ''
        if n==0: return ''
        zero = False
        i = -1
        while n>0:
            t = n%10
            n //= 10
            i+=1
            if t==0: 
                zero = True
                continue
            if zero and res!='':
                res = digit[0] + res
            res = digit[t] + unit[i] + res
        return res
            
    WAN = 10000
    pos = 0
    last = 0
    while n>0:
        t = n%WAN
        n //= WAN
        tmp = deal(t)
        if pos==1: tmp += 'Wan'
        if pos==2: tmp += 'Yi' 
        pos+=1
        if last<1000 and pos>=1 and res!='': tmp += 'Ling'
        res = tmp + res
        last = t
        
    return res
    
def num2chinese(n):
    if n>=0: return posnum2chinese(n)
    return 'Fu' + posnum2chinese(-n)

to19 = 'One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve ' \
               'Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen'.split()
tens = 'Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety'.split()

def helper(num):
    if num < 20:
        return to19[num - 1:num]
class Solution:
    def numberToWords(self, num: int) -> str:
        to19 = 'One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve ' \
               'Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen'.split()
        tens = 'Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety'.split()

        def helper(num):
            if num < 20:
                return to19[num - 1:num]
            if num < 100:
                return [tens[num // 10 - 2]] + helper(num % 10)
            if num < 1000:
                return [to19[num // 100 - 1]] + ["Hundred"] + helper(num % 100)
            for p, w in enumerate(["Thousand", "Million", "Billion"], 1):
                if num < 1000 ** (p + 1):
                    return helper(num // 1000 ** p) + [w] + helper(num % 1000 ** p)

        return " ".join(helper(num)) or "Zero"

print(helper(0))
print(helper(1))
print(num2chinese(200000))
print(num2chinese(200001))
print(num2chinese(201001))
print(num2chinese(200101))
print(num2chinese(135605000))
print(num2chinese(200001))
s = Solution()
print(s.numberToWords(1001))
print(s.numberToWords(5011))
print(s.numberToWords(5021))
print(s.numberToWords(5031))