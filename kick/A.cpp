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
        s_odd[i] = s_odd[i] + S[i]%2;
    }
}
typedef pair<LL, int> P;
int main()
{
    int _,ca=1; cin>>_;
    while (_--) {
        cin>>N>>O>>D;
        cin>>X[1]>>X[2]>>A>>B>>C>>M>>L;
        GenData();
        set<P> a;
        LL ans = -1e18;
        LL f = -1e10;
        int start=-1, odd=0;
        for (int i=0;i<N;i++) {
            if (start==-1) {
                if (odd + (S[i]%2==1) <= O && S[i]<=D) {
                    f = S[i];
                    odd += (S[i]%2==1);
                }
                continue;
            }
            if (f>0) {
                if
            } else { /// f<=0
                if (S[i]>D && S[i]+f<=D) {
                    /// f = f+ S[i]
                    if (odd + S[i]%2<= O ) {
                        ans
                    }
                }
            }
        }
        printf("Case #%d:", ca++);
    }
}
