# 27*26 -

class Solution:
    def excelColumn(self, n):
        res = ''
        while n>0:
            t=(n-1)%26
            res = chr(t+ord('A'))+res
            n = (n-1)//26
        return res
    def getNumber(self, s):
        res = 0
        for c in s:
            res = res*26+ord(c)-ord('A')+1
        return res

s = Solution()
print(s.excelColumn(1))
print(s.excelColumn(26))
print(s.excelColumn(27))
print(s.excelColumn(27*26))
print(s.excelColumn(24*26+5))
print(s.excelColumn(s.getNumber('AC')))
print(s.excelColumn(s.getNumber('AAZ')))
print(s.excelColumn(s.getNumber('ASDFTRZ')))
print(s.excelColumn(s.getNumber('SGRFGJFGDJRZ')))
print(s.excelColumn(s.getNumber('SGRFGJDFGD')))
print(s.getNumber('EX'))
print(s.getNumber('ZZ'))
print(s.excelColumn(26*26*26))
print(s.excelColumn(28*26))