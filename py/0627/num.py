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
    
print(num2chinese(200000))
print(num2chinese(135605000))
print(num2chinese(200001))