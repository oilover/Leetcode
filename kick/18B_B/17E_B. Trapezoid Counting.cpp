#include <iostream>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr<<#k" = "<<k<<endl;
typedef long long LL;
void read(int &x) { scanf("%d",&x);  }
const int MAXN = 5066;
vector<LL> a;
map<LL,int> cnt;
int n;
LL Conbine(LL n) {
    return n*(n-1)*(n-2)/6;
}
LL C2(LL n)
{
    return n*(n-1)/2;
}
int main()
{
    int _; cin>>_; int ca=1;
    while (_--) {
        cin>>n; a.clear();cnt.clear();
        for (int i=0;i<n;i++) {
            int x; read(x); a.push_back(x);
            cnt[x]++;
        }
        sort(a.begin(), a.end());
        vector<LL> arr = a; /// use to lower_bound
        a.erase(unique(a.begin(),a.end()), a.end());
        n = a.size();
        printf("Case #%d:", ca++);
        LL ans = 0;
        for (int i=0;i<n;i++) {
               LL A=a[i]; if (cnt[A]<2) continue;
            for (int j=0;j<n;j++) if(i-j) {
                LL B=a[j];
                LL t = lower_bound(arr.begin(),arr.end(),2LL*A+B)
                  - upper_bound(arr.begin(),arr.end(), B); /// (B, 2A+B)
                if (B<A) t-=cnt[A];
                ans += t * C2(cnt[A]) * cnt[B];
            }
            if (cnt[A]>=3) {
                LL t = lower_bound(arr.begin(),arr.end(), 3LL*A) - arr.begin();
                ans += Conbine(cnt[A]) * (t - cnt[A]);
            }
        }
        cout<<" "<<ans<<endl;
    }
    return 0;
}
