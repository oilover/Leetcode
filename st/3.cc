#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 100100;
typedef pair<int,int> P;
template <class T>
void print(vector<T> v) {
    for (auto x: v) cout<<" "<<x; cout<<endl;
}
const int INF = 1e9+1;

int n;
int a[N], nxt[N];
int gao(vector<int> a) {
    int dp = -INF, f = 0;
    int n = a.size();
    for (int i=1;i<=n;i++) {
        f = max(f+a[i-1],a[i-1]);
        dp = max(dp, f);
    }
    return (int) dp;
}
int sum[N];
int dpr[N], dp[N];

int Gao(vector<int> a) { // cycle
    sum[0] = 0;
    dp[0] = 0; int n = a.size();
    for (int i=1;i<=n;i++) {
        sum[i] = sum[i-1] + a[i-1];
        dp[i] = max(dp[i-1], sum[i]);
    }
    dpr[n+1] = 0;
    for (int i=n;i>0;i--) {
        dpr[i] = max(dpr[i+1], sum[n]-sum[i-1]);
    }
    int ans = -1e9;
    for (int i=1;i<=n;i++) {
        ans = max(ans, dpr[i] + dp[i-1]);
    }
    return ans;
}
bool vis[N], cycle[N];

void find_cycle(int head) {

}
int main(int argc, char const *argv[])
{
    /* code */
    memset(vis, false, sizeof vis);
    memset(cycle, false, sizeof cycle);
    cin>>n;
    for (int i=1;i<=n;i++) {
        read(a[i]); read(nxt[i]);

    }
    int ans = -1e9;
    for (int i=1;i<=n;i++) if (!vis[i]) {
        int s=i, f=i;
        for (;   ; ) {
            s = nxt[s];
            f = nxt[nxt[f]];
            // prt(s); prt(f); cout<<endl;
            if (s==f) break;
        }
        vector<int> A, cyc, B;
        s = i;
        while (s-f) { 
            A.push_back(a[s]); vis[s] = true;
            s = nxt[s], f=nxt[f];
        }
        int start = s;
        // B.push_back(s); A.push_back(s); //vis[s] = true;
        // f = nxt[start];
        do {
            B.push_back(a[f]); A.push_back(a[f]);
          //  vis[f] = true;
            f = nxt[f];
        } while (f-start) ;
        // cout<<"A:"; print(A);
        // cout<<"B:"; print(B);
        ans = max(ans, gao(A));
        ans = max(ans, Gao(B));
    }
    cout<<ans<<endl;
    return 0;
}
/**
 * 
6
-1 2
3 3
-2 1
-1 1
4 4
1 2

ans: 5

*/