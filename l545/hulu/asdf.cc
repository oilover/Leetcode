#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
const int N = 100100;
int bit[89], len;
int dp[77][67];
int dfs(int pos, int s,  bool lim) {
    if (pos==-1) return s<3;
    if (!lim && ~dp[pos][s]) return dp[pos][s];
    int end = lim ? bit[pos] : 1;
    int ans = 0;
  //  prt(pos); prt(s) ; cout<<endl;
    for (int i=0;i<=end;i++) {
        int ss = s;
        if (s==2 && i==1) continue;
        if (i==1) ss = s+1;
        else ss = 0;
        ans += dfs(pos-1, ss, lim && i==end);
    }
    if (!lim) dp[pos][s] = ans;
    return ans;
}
void fj(int n) {
    len=0;
    while (n>0) {
        bit[len++] = n%2;
        n/=2;
    }
}
int main(int argc, char const *argv[])
{
    int n; cin>>n;
    fj(n);
    memset(dp,-1,sizeof dp);
    cout<<dfs(len-1, 0, true)<<endl;
    return 0;
}
