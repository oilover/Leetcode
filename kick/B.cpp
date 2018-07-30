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
  //  assert(p[1]<=M1); assert(x[1]<=M3);
//    p[1]=p[1]%M1+1; p[2]=p[2]%M1+1;
    get_data(p,n);
    get_data(h,n);
    get_data(x,K);
    get_data(y,K);
//    for (int i=3;i<=n;i++) {
//        p[i] = (B1*p[i-2]%M1 + C1) % M1;
//        p[i] = (A1*p[i-1]%M1 + p[i]) % M1 +  1;
//        h[i] = (A2*h[i-1]%M2 + (B2*h[i-2]%M2 + C2) % M2) % M2 + 1;
//    }
//    for (int i=3;i<=K;i++) {
//        x[i] = (A3*x[i-1]%M3 + (B3*x[i-2]%M3 + C3)%M3 ) % M3 + 1;
//        y[i] = (A4 * y[i - 1]%M4 + (B4 * y[i - 2]%M4 + C4)%M4) % M4 + 1;
//    }
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
     //   prt(x[2]);prt(y[2]); prt(p[3]);prt(h[3]);
        printf("Case #%d: ", ca++);
        cout<<ans<<endl;
    }
}
