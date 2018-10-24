#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 2000100;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
LL n;
LL gcd(LL a, LL b) {
    return b==0 ? a : gcd(b,a%b);
}
LL a,b,c;
int main()
{
    int T; cin>>T;
    while (T--) {
            cin>>a>>n>>b;
        LL d = gcd(a,n);
        puts(b%d==0 ? "YES" : "NO");
    }
//    while (cin>>n) {
//        cout<<2*n<<endl;
//    }
}
