#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
const int N = 100100;
int n,K;
int a[N];
int main(int argc, char const *argv[])
{
    int _, ca=1; cin>>_;
    while (_--) {
        cin>>n>>K; for (int i=0;i<n;i++) read(a[i]);
        sort(a, a+n);
        int day = 0, ans=0, cnt=0;
        for (int i=0;i<n;i++) {
            if (day < a[i] && cnt<K) {
                ++cnt; ++ans;
                if (cnt % K==0) {
                    cnt = 0;
                    day++;
                }
            }
        }
        printf("Case #%d: ", ca++);
        
        cout<<ans<<endl;
    }
    return 0;
}
