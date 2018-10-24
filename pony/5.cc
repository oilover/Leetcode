#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 500100;
typedef pair<int,int> P;
double dp[N];
int M, A, R;
int main(int argc, char const *argv[])
{
    cin>>M>>A>>R;
    if (M<A || M>=A+R) {
        printf("%.5f\n", 0);
        // cout<<"0.00000\n"
        return 0;
    }
    dp[0] = 1;
    double ans = 0;
    for (int i=1;i<=M;i++) {
        for (int x=max(i-R,0);x<i&&x<A; x++) {
            dp[i] += dp[x] / R;
        }
        // cout<<i<<" "<<dp[i]<<endl;
        if (i>=A) ans += dp[i];
    }
    printf("%.5f\n", ans);
    return 0;
}
