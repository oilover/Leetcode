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
typedef pair<int,string> PS;
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
        priority_queue<PS> pq;
        string best(P,'0'); int tmp = 0;
        for (int i=0;i<P;i++) {
            if (cnt[i]>n/2) best[i]='1';
            tmp+=min(cnt[i],n-cnt[i]);
        }
        pq.push(PS(-tmp, best));
        set<string> vis;
        vis.insert(best);
        while (!pq.empty()) {
            PS ps = pq.top(); pq.pop();
            string s = ps.second;
         //   prt(s); prt(ps.first); cout<<endl;
            if (forbid.count(s)==0) {
                ans = -ps.first;
                break;
            }
            for (int i=0;i<P;i++) {
                s[i]= s[i]=='0'? '1' : '0';
                if (vis.count(s) ==0) {
                    int cost = -ps.first;
                    int t = cnt[i]-(n-cnt[i]);
                    if (s[i]=='1') cost -= t;
                    else cost += t;
                //    if (s=="1110") puts("===");
                    pq.push(PS(-cost, s));
                    vis.insert(s);
                }
                s[i]= s[i]=='0'? '1' : '0';
            }
        }
        printf("Case #%d: ", ca++); cout<<ans<<endl;
    }
}