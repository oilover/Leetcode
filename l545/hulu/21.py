def div(a,b):
    return (a+b-1)//b
a,b=map(int,input().split(' '))
t=-a
A,B = a,-b
x = 7-div(7*A, B+A)
t = 2*x + min(x,3)
ans =  t*a + (17-t)*b
print (ans)