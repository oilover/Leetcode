#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }

int main(int argc, char const *argv[])
{
    int _, ca=1; cin>>_;
    while (_--) {
        LL L,R;
        cin>>L>>R;
        LL n = min(L,R);

        printf("Case #%d: ", ca++);
        LL ans = n*(n+1)/2;
        cout<<ans<<endl;
    }
    return 0;
}
