# global N, self.charset
class Roman:
    def __init__(self, charset):
        self.charset = charset
        self.N = len(self.charset)
        
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        # N, self.charset = 7, 'IVXLCDM'
        if num<=0: raise Exception("sadf")
        ans =  []
        i = 0;
        while (num > 0):
            x = num % 10
            num //= 10
            if (i>=self.N): raise ValueError("sdaf")
            if 1<=x and x<=3:
                ans.append(self.charset[i]*x)
            if x==4:
                if (i+1>=self.N): raise ValueError("sdaf")
                ans.append(self.charset[i] + self.charset[i+1])
            if x in [5,6,7,8]:
                if (i+1>=self.N): raise ValueError("sdaf")
                ans.append( self.charset[i+1] + (x-5)*self.charset[i])
            if x==9:
                if (i+2>=self.N): raise ValueError("sdaf")
                ans.append( self.charset[i] + self.charset[i+2])
            i+=2
            print(num, x, ans)
        return ''.join(ans[::-1]);
class Solution:
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        num = int(num)
        r = Roman('ABCDEFGHIJKL') # IVXLCDM')
        return r.intToRoman(num)

print (Solution().intToRoman(4345) )