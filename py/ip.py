class Solution:
    def validIPAddress(self, IP: str) -> str:
        def ok10(s):
            if len(s)==0: return False
            if not s.isdigit(): return False
            n = int(s)
            if s[0]=='0' and len(s)>1: return False
            if n>255: return False
            return True
        def ok16(s):
            if len(s)==0: return False
            hexdigits = '0123456789abcdefABCDEF'
            x = s
            if len(x) == 0 or len(x) > 4 or not all(c in hexdigits for c in x):
                return False
            # if s[0]=='0' and n>0:
            #     if s[1:].isdigit(): return False
            # if n>=2**16: return False
            return True
        nums = IP.split('.')
        n = len(nums)
        if n!=1 and n!=4:
            return "Neither"
        if n==4:
            for s in nums:
                if not ok10(s):
                    return "Neither"
            return "IPv4"
        nums = IP.split(':')
        n = len(nums)
        if n!=8: return "Neither"
        for s in nums:
            if not ok16(s):
                return "Neither"
        return "IPv6"

# s = Solution
print(Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"))