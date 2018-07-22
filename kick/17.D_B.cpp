#include <iostream>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &x) { scanf("%d",&x);  }
const int MAXN = 233;
int n,K,x[MAXN],y[MAXN],C,D,E1,E2,F; int r[MAXN],s[MAXN];
int A[MAXN], B[MAXN], mat[MAXN][MAXN];
LL sum[MAXN][MAXN];
void generateData()
{
    r[1] = s[1] = 0;
    for (int i=2;i<=n;i++) {
        x[i] = (C*x[i-1] + D*y[i-1] + E1) % F;
        y[i] = (D*x[i-1] + C*y[i-1] + E2) % F;
        r[i] = (C*r[i-1] + D*s[i-1] + E1) % 2;
        s[i] = (D*r[i-1] + C*s[i-1] + E2) % 2;

    }
    for (int i=1;i<=n;i++) {
        A[i] = r[i]%2==0? x[i] : -x[i];
        B[i] = s[i]%2==0 ? y[i]: -y[i];
    }
    for (int i=1;i<=n;i++) {
        for (int j=1;j<=n;j++) {
            mat[i][j] = A[i]*B[j];
        }
    }
    memset(sum,0,sizeof sum);
    for (int i=1;i<=n;i++) {
        for (int j=1;j<=n;j++) {
            sum[i][j] = sum[i][j-1] + mat[i][j];
        }
    }for (int i=1;i<=n;i++) {
        for (int j=1;j<=n;j++) {
            sum[i][j] = sum[i-1][j] + sum[i][j];
        }
    }
}
multiset<LL> all_sum;
void enumerate()
{
    all_sum.clear();
    for (int a=1;a<=n;a++) for (int b=1;b<=n;b++) {
        for (int c=a;c<=n;c++) for (int d=b;d<=n;d++) {
            LL S = sum[c][d] - sum[a-1][d] - sum[c][b-1] + sum[a-1][b-1];
            all_sum.insert(S);
            if (all_sum.size() > K) {
                all_sum.erase(all_sum.begin());
            }
          //   for (auto t:all_sum) prt(t);cout<<endl;
        }
    }
}
int main()
{
    int _,ca=1; cin>>_;
    while (_--) {
        cin>>n>>K>>x[1]>>y[1]>>C>>D>>E1>>E2>>F;
        generateData();
        enumerate();
        printf("Case #%d:", ca++);
        cout<<" "<<*all_sum.begin()<<endl;
    }
    return 0;
}
