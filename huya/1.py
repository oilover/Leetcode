import sys
for s in sys.stdin:
    s = ''.join([c for c in s if c!=' '])
    print(s[:6],end='')
    if len(s)>6: print(' '+s[6:14], end='')
    if len(s)>14: print(' ' + s[14:],end='')