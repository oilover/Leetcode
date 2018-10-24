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
LL a[N]; int n;
int main(int argc, char const *argv[])
{
    while (cin>>n) {
        a[0] = 0;
        LL ans = 0;
        for (int i=1;i<=n;i++) {
            read(a[i]);
            a[i] += a[i-1];
        }
        for (int i=n-1;i>0;i--) {
            LL t = a[n]-a[i];
            if (t > a[i]) break;
            int j = lower_bound(a,a+i,t)-a;
            if (j<=i && a[j]==t) {
                ans = t;
            }
        }
        cout<<ans<<endl;
    }
    return 0;
}
