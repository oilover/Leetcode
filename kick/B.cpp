#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
const int N = 100100;
int n,m,P;
int a[N];
int cnt[N];
set<string> forbid;
string f(int s) {
    string ret(P, '0');
    for (int i=0;i<P;i++) if (s>>i&1) ret[i]='1';
    return ret;
}
int main(int argc, char const *argv[])
{
    int _, ca=1; cin>>_;
    while (_--) {
        cin>>n>>m>>P;    memset(cnt,0,sizeof cnt);
        forbid.clear();
        for (int i=0;i<n;i++) {
            string s;
            cin>>s;
            for (int j=0;j<P;j++) {
                cnt[j]+=s[j]=='1';
            }
        }
        for (int i=0;i<m;i++) {
            string s; cin>> s;
            forbid.insert(s);
        }
        int ans = N*P;
        for (int mask=0;mask<(1<<P);mask++) {
            string s = f(mask);
            if (forbid.count(s)>0) continue;
            int tot = 0;
            for (int i=0;i<P;i++) {
                if (s[i]=='1') tot+=n-cnt[i];
                else tot+=cnt[i];
            }
        //    prt(s); prt(tot); cout<<endl;
            ans = min(ans, tot);
        }
        printf("Case #%d: ", ca++); cout<<ans<<endl;
    }
}