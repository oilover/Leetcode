#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 500100;
typedef pair<int,int> P;
int a[N], n , m;
int b[N];
int getCnt(int m) {
    memset(b,-1,sizeof b);
    int c=0;
    for (int i=0;i<n;i++) {
        int p = a[i] % m;
        if (b[p]==-1 || b[p]==a[i]) c++;
        b[p] = a[i];
    }
    return c;
}
int main(int argc, char const *argv[])
{
    cin>>n; for(int i=0;i<n;i++) read(a[i]);
    if (n==0) {
        cout<<0<<endl; return 0;
    }
    int maxc = getCnt(1005);
    int l=1,r=1005;
    // while (r>1 and getCnt(r-1)==maxc) r--;
    // cout<<r<<endl;
    while (l<r) {
        int mid = (l+r)/2;
        if (getCnt(mid)<maxc) l=mid+1;
        else r=mid;
    }
    cout<<l<<endl;
    return 0;
}
