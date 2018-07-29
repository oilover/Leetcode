#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr<<#k" = "<<k<<endl;
typedef long long LL;
const int INF = 0x3f3f3f3f;
void read(int &x) { scanf("%d",&x);  }
const int MAXN = 501289;
LL X[MAXN], S[MAXN], N,O,D,A,B,C,M,L;
LL sum[MAXN], s_odd[MAXN];
void GenData()
{
    for (int i=3;i<=N;i++) {
        X[i] = (A*X[i-1] + B*X[i-2] + C) % M;

    }
    sum[0] = s_odd[0] = 0;
    for (int i=1;i<=N;i++) {
        S[i] = X[i] + L;
        sum[i] = sum[i-1] + S[i];
        s_odd[i] = s_odd[i-1] + S[i]%2;
    }
}
typedef pair<LL, int> P;
void print(P p)
{
    printf(" (%lld,%d)", p.first, p.second);
}
int main()
{
    int _,ca=1; cin>>_;
    while (_--) {
        cin>>N>>O>>D;
        cin>>X[1]>>X[2]>>A>>B>>C>>M>>L;
        GenData();
        set<P> aset;
        LL ans = -1e18;
        LL f = -1e10;
        int start=-1, odd=0;
        aset.insert(P(0,0));
        for (int i=1;i<=N;i++) {
            if (S[i]%2==1 && s_odd[i] > O) {
                int lo =  lower_bound(s_odd, s_odd+i, s_odd[i]-O-1) - s_odd;
                int hi = upper_bound(s_odd, s_odd+i, s_odd[i]-O-1) - s_odd;
                for (int k=lo;k<hi;k++) {
                    aset.erase(P(-sum[k],k));
                 //   cout<<" *"<<k;
                }
            } //cout<<" ---"<<i<<endl;
            auto p = aset.upper_bound(P(D-sum[i],i));
            if (p!=aset.begin()) p--;
            else {
                continue;
            }  //print(*p); prt(s_odd[i]-s_odd[p->second]);

//            while (p!=aset.begin() && s_odd[i]-s_odd[p->second] > O ) {
//                if (sum[i] + p->first <= ans) break;
//               // printf("-->"); print(*p);
//                p--;
//            }
            if (s_odd[i]-s_odd[p->second] <= O ) {
                ans = max(ans, sum[i] + p->first);
            }// prt(ans);
            aset.insert(P(-sum[i],i));
        }
        printf("Case #%d: ", ca++);
        if (ans <= (LL)-1e18) {
            puts("IMPOSSIBLE");
        }
        else {
            cout<<ans<<endl;
        }
    }
}
