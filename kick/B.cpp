#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr<<#k" = "<<k<<endl;
typedef long long LL;
const int INF = 0x3f3f3f3f;
void read(int &x) { scanf("%d",&x);  }
const int MAXN = 1500289;
const int N = MAXN;
int n, K;
LL A1,A2,A3,A4,B1,B2,B3,B4,C1,C2,C3,C4, M1,M2,M3,M4;
LL p[N],h[N],x[N],y[N];
void get_data(LL* res, int n) {
    int a, b, c, m;
    cin >> res[1] >> res[2] >> a >> b >> c >> m;
    for (int i = 3; i <= n; ++i)
        res[i] = (1LL * a * res[i - 1] + 1LL * b * res[i - 2] + c) % m + 1;
}
void genData()
{
    get_data(p,n);
    get_data(h,n);
    get_data(x,K);
    get_data(y,K);
}
int main()
{
    int _,ca=1; cin>>_;
    while (_--) {
        cin>>n>>K;
        genData();
        int ans=0;
        for (int i=1;i<=K;i++) {
            bool OK = false;
            for (int j=1;j<=n;j++)  {
                if (abs(x[i]-p[j])<=h[j]-y[i]) {
                    OK = true; break;
                }
            }
            if (OK) ans ++; //ans += OK;
        }
        printf("Case #%d: ", ca++);
        cout<<ans<<endl;
    }
}
