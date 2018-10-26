import sys

for s in sys.stdin:
    n = len(s)
    Scnt = []
    Sstr = []
    i = 0
    last, ans = '' ,''
    while i<n:
        ch = s[i]
        if ch.isdigit():
            Scnt.append(int(ch))
            i+=1
            continue
        if ch=='[':
            i+=1
            tmp = []
            while i<n and s[i].isalpha():
                tmp.append(s[i])
                i+=1
            Sstr.append(''.join(tmp))
            continue
        if ch==']':
            tmp, cnt = Sstr[-1], Scnt[-1]
            Sstr.pop()
            Scnt.pop()
            # last = tmp + last
            last = cnt * (tmp + last) # ''.join[tmp, last] #(tmp+last)
            if len(Scnt)==0:
                ans = ans + last
        else:
            ans += ch
        i+=1
    print(ans)

'''
sample:
a3[b2[c1[d]]]e
abcdcdbcdcdbcdcde
'''