#include <iostream>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr<<#k" = "<<k<<endl;
typedef long long LL;
void read(int &x) { scanf("%d",&x);  }
using namespace std;
const int Mod = 1e9+7;
const int MAXN = 1001203;
int n, K, x_1, y_1, C, D, E_1, E_2, F;
LL x[MAXN],y[MAXN], A[MAXN];;
LL power(LL a, LL n) {
    LL res = 1;
    for (; n>0; a=a*a%Mod, n>>=1) if (n&1) {
        res = res * a % Mod;
    }
    return res;
}
LL NY(LL a) {
    return power(a, Mod-2);
}
void generateA()
{
    x[1] = x_1, y[1] = y_1;
    A[1] = (x[1]+y[1])% F;
    for (int i=2;i<=n;i++) {
        x[i]=(C*x[i-1] + D*y[i-1] + E_1) % F;
        y[i] = (D*x[i-1] + C*y[i-1] + E_2) % F;
        A[i] = (x[i] + y[i]) % F;
    }
}
LL Pow[MAXN]; /// 1^i, 2^i, ...
int main()
{
    int _; cin>>_; int ca=1;
    while (_--) {
        cin>>n>>K>>x_1>>y_1>>C>>D>>E_1>>E_2>>F;
        generateA();  printf("Case #%d:", ca++);

        LL sum = 0;
        LL ans = 0; LL N = n;
        for (int i=1;i<=n;i++) Pow[i]=i % F;
        for (int i=1;i<=n;i++) {
            if (i==1) sum=K;
            else {
                sum = (sum + (power(i,K+1)-i) * NY(i-1) % Mod) % Mod;


            }
            ans = (ans + A[i]*(N-i+1) % Mod * sum % Mod ) % Mod;
        }
        printf(" %lld\n", ans);
    }
    return 0;
}
