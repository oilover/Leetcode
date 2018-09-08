#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 100100;
typedef pair<int,int> P;
const LL INF = 1e18;
int n,k;
LL a[N];
int main(int argc, char const *argv[])
{
    
    while (cin>>n>>k) {
        LL sum = 0;
        for (int i=0;i<n;i++) read(a[i]), sum+=a[i];;
        LL mi = INF, ma = -INF;
        for (int i=0;i<n;i++) {
            if (a[i]*n < sum) {
                a[i]+=k;
            } else {
                a[i]-=k;
            }
            mi = min(mi, a[i]);
            ma = max(ma, a[i]);
        }
        cout<<ma-mi<<endl;
    }
    return 0;
}
