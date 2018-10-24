#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 500100;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
int n;
struct Node {
    int a,b,c;
    bool operator < (Node rhs) const {
        if (a- rhs.a) return a<rhs.a;
        if (b- rhs.b) return b<rhs.b;
        return c<rhs.c;

    }
}p[N];

int main(int argc, char const *argv[])
{
    cin>>n;
    for (int i=1;i<=n;i++) {
        int a,b,c; read(a);read(b);read(c); 
        p[i] = (Node){a,b,c};
    }
    sort(p+1,p+n+1);

    set<int> S; // c
    stack<Node> stk;
    int ans = 0;
    for (int i=n;i>=1;i--) {
        bool ok = false;
        for (int j=i+1;j<=n;j++) if (p[j].a>p[i].a && p[j].b>p[i].b && p[j].c>p[i].c) {
            ok = true;
            break;
        }
        ans += ok;
    }
    // for (int i=n;i>=1;i--) {
    //     while (!stk.empty() && stk.top().b<=p[i].b) {
    //         S.erase(stk.top().c);
    //         stk.pop();
    //     }
    //     if (!S.empty() ) {
    //         auto tmp = *S.begin();
    //     } && *S.begin()>p[i].c) ans++;
    //     stk.push(p[i]);
    //     S.insert(p[i].c);
    // }
    cout<<ans<<endl;
    return 0;
}
/**
 3
1 4 2
4 3 2
2 5 3

out:1
*/
