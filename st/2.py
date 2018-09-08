def f(s):
    n,f=len(s),1
    ans = 1
    for i in range(1,n):
        if (s[i]-s[i-1]) f+=1
        else f=1;
        ans = max(ans, f);
    return ans;

def left(s):
    n,f=len(s),1
    for i in range(1,n):
        if (s[i]-s[i-1]) f+=1
        else return f;
    return n;