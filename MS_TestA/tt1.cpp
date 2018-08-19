#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
const int MAXN = 100010;
const int N = MAXN;
int a[N],b[N];
int mm[MAXN]; int n;
namespace AA {
int dp[MAXN][20];
    //初始化RMQ, b数组下标从1开始，从0开始简单修改
    void initRMQ(int n,int b[])
    {
    mm[0] = -1;
    for(int i = 1; i <= n;i++)
    {
    mm[i] = ((i&(i-1)) == 0)?mm[i-1]+1:mm[i-1];
    dp[i][0] = b[i];
    }
    for(int j = 1; j <= mm[n];j++)
    for(int i = 1;i + (1<<j) -1 <= n;i++)
    dp[i][j] = max(dp[i][j-1],dp[i+(1<<(j-1))][j-1]);
    }
    //查询最大值
    int rmq(int x,int y)
    {
    int k = mm[y-x+1];
    return max(dp[x][k],dp[y-(1<<k)+1][k]);
    }
};
namespace BB {
int dp[MAXN][20];
    //初始化RMQ, b数组下标从1开始，从0开始简单修改
    void initRMQ(int n,int b[])
    {
    mm[0] = -1;
    for(int i = 1; i <= n;i++)
    {
    mm[i] = ((i&(i-1)) == 0)?mm[i-1]+1:mm[i-1];
    dp[i][0] = b[i];
    }
    for(int j = 1; j <= mm[n];j++)
    for(int i = 1;i + (1<<j) -1 <= n;i++)
    dp[i][j] = min(dp[i][j-1],dp[i+(1<<(j-1))][j-1]);
    }
    //查询最大值
    int rmq(int x,int y)
    {
    int k = mm[y-x+1];
    return min(dp[x][k],dp[y-(1<<k)+1][k]);
    }
};
int main(int argc, char const *argv[])
{
    while (cin >> n) {
        for (int i=1;i<=n;i++) read(a[i]);
        for (int i=1;i<=n;i++) read(b[i]);
        AA::initRMQ(n,a);
        BB::initRMQ(n, b);
        LL ans = 0;
        for (int i=1;i<=n;i++) {
            int l = i, r=n+1;
            while (l<r) {
                int mid = l+(r-l)/2;
                int Amax = AA::rmq(i,mid);
                int Bmin = BB::rmq(i,mid);
                if (Amax < Bmin) l = mid;
                else r = mid-1;
            }
            ans += l-i;
        }
        cout<<ans<<endl;
    }
    return 0;
}
