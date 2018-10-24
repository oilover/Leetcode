#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 100100;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
int n;

    typedef unsigned long long ull;
const ull base = 173;
    char a[N], b[N];
ull p[N];
    ull ha[N], hb[N];

    void init(char *s, ull hash[]){//处理hash值

        hash[0] = 0;
        int n = strlen(s );

       for(int i = 1; i <= n; i ++) hash[i] = hash[i - 1] * base + (s[i-1] - 'a');
    }

    ull get(int l, int r, ull g[]){//取出g里l - r里面的字符串的hash值
        return g[r] - g[l - 1] * p[r - l + 1];
    }

int main()
{
    p[0] = 1; for(int i = 1; i <N; i ++)p[i] =p[i-1] * base;
    while (scanf("%s%s",a,b)!=EOF) {
        int an = strlen(a), bn = strlen(b);
      //  prt(a); prt(b);
        int n = min(an, bn);
        init(a, ha); init(b, hb);
        int ans = 0;
        for (int i=n;i>=1;i--) {
            ull x = get(an-i+1, an, ha), y = get(1, i, hb);
           // prt(x); prt(y);
            if (x==y) {
                ans = i; break;
            }
        }
        cout<<ans<<endl;
    }
}
