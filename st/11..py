rows = input().split('|')
a = [list(map(int,row.split(','))) for row in rows]
# print(a)
tar = int(input())
ok = False
n,m = len(a),len(a[0])
x,y= 0,m-1
while x<n and y>=0:
    if a[x][y]==tar:
        ok = True
        break;
    if a[x][y] > tar:
        y-=1
    else:
        x+=1
print ('true' if ok else 'false')