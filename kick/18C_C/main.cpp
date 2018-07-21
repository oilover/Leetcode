#include <iostream>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr<<#k" = "<<k<<endl;
typedef long long LL;
void read(int &x) { scanf("%d",&x);  }
using namespace std;
const int Mod = 1e9+7;
const int N = 203;
int n, K, x_1, y_1, C, D, E_1, E_2, F;
LL x[N],y[N], A[N];;
LL power(LL a, LL n) {
    LL res = 1;
    for (; n>0; a=a*a%Mod, n>>=1) if (n&1) {
        res = res * a % Mod;
    }
    return res;
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
LL Pow[N]; /// 1^i, 2^i, ...
int main()
{
    int _; cin>>_; int ca=1;
    while (_--) {
        cin>>n>>K>>x_1>>y_1>>C>>D>>E_1>>E_2>>F;
        generateA();  printf("Case #%d:", ca++);

        LL sum = 0;
        for (int i=1;i<=n;i++) Pow[i]=i % F;
        for (int pow_i=1; pow_i<=K; pow_i++) {
            for (int i=1;i<=n;i++) {
                for (int j=i;j<=n;j++) {
                    for (int id=i;id<=j;id++) {
                        sum=(sum + A[id]*Pow[id-i+1]%Mod) % Mod;
                    }
                }
            }
            for (int i=1;i<=n;i++) Pow[i] = Pow[i] * i % Mod;
        }
        printf(" %lld\n", sum);
    }
    return 0;
}
