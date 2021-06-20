#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 5100;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
int n,m;
int a[N];
int main(int argc, char const *argv[])
{
    cin>>n;
    for (int i=0;i<n;i++) cin>>a[i];
    sort(a,a+n);
    for (int i=0;i<n;i++) a[i+n]=a[i]+36000;
    LL ans = 0;
    for (int i=0; i<n; i++) {
        int t = lower_bound(a+i, a+n+i, a[i]+18000) - a-i-1;
        if (t>1) ans += t*(t-1)/2;
    }
    
   // ans /= 3;
    cout<<ans<<endl;
    return 0;
}
/*
4
0
10000
12000
18000
*/