rows = input().split('|')
a = [list(map(int,row.split(','))) for row in rows]
# print(a)
tar = int(input())
ok = False
n,m = len(a),len(a[0])
x,y= n-1,0
while x>=0 and y<=m-1:
    if a[x][y]==tar:
        ok = True
        break;
    if a[x][y] > tar:
        x-=1
    else:
        y+=1
print ('true' if ok else 'false')