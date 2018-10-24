import sys
for s in sys.stdin:
    d = {}
    for c in s: 
        if c==' ': continue
        if not c in d: d[c]=0
        d[c]+=1
        if d[c]==3:
            print(c)
            break