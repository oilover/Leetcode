from typing import List

less20 = 'One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve ' \
               'Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen'.split()
# 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。['One','Nineteen']
tens =  'Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety'.split()

    # ['Twenty','Thirty', 'Ninety']
class Solution:
    def numberToWords(self, num: int) -> str:
        def helper(n) -> List[str]:
            if n<20: return less20[n-1:n]
            if n<100: return [tens[n//10-2]] + helper(n%10)
            if n<1000: return helper(n//100) + ['Hundred'] + helper(n%100)
            res = []
            power = 1000 #1000**p
            res = helper(n%power)
            for p, w in enumerate(['Thousand','Million','Billion']):
                n//=power
                if n==0: break
                if n%power>0:#=power:
                    res = helper(n%power) + [w] + res
            return res #helper(n//1000) + helper(n%1000)
        if num==0: return 'Zero'
        return ' '.join(helper(num))

s = Solution()
print(s.numberToWords(1000))
print(s.numberToWords(1000000))
print(s.numberToWords(123))
print(s.numberToWords(12345))
print(s.numberToWords(1231230000))