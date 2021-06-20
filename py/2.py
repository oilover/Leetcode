
class Solution:
    def numberOfRounds(self, startTime: str, finishTime: str) -> int:
        def getH(s: str):
            return int(s.split(':')[0])
        def getM(s: str):
            return int(s.split(':')[1])
        sh, sm = getH(startTime), getM(startTime)
        eh, em = getH(finishTime   ), getM(finishTime)
        if (startTime > finishTime) :
            eh += 24
            finishTime = str(getH(finishTime)+24) + ':' + str(getM(finishTime))
        
        def f(h,m): 
            return h*60+m
        if sm %15 >0:
            sm = sm + 15-sm%15
        if em %15 >0:
            em = em - em%15
        return -(f(sh, sm) - f(eh, em)) / 15
            # if (sm%60==0): hm

s = Solution()
print(s.numberOfRounds("12:01", finishTime = "12:44"))    

print(s.numberOfRounds(startTime = "20:00", finishTime = "06:00"))    
print(s.numberOfRounds("00:00", finishTime = "23:59"))    
