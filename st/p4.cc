#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
int n;
set<int> dp0(vector<int> a, int cond=0) {
    int n=a.size();
    vector<int> dp(n,1), pre(n,-1);
    map<int,int> cnt; for (int x:a)cnt[x]++;
    for (int i=1;i<n;i++) {
        for (int j=0;j<i;j++) if((cond==0?a[j]<a[i]:a[j]>a[i]) && (dp[i]<dp[j]+1 ||
            (dp[i]==dp[j]+1&&cnt[a[pre[i]]] < cnt[a[j]]) )) {
            dp[i]=dp[j]+1;
            pre[i]=j;
        }
    }
    int ans=0,ed=-1;
    for (int i=0;i<n;i++) if (dp[i]>ans) {
        ans=dp[i], ed=i;
    }
    int i=ed; set<int> ret;
    while (i!=-1) {
        ret.insert(i);
        i=pre[i];
    }
    return ret;
}

int main() {
    vector<int> a;
    while (cin>>n) {
        for (int i=0;i<n;i++) {
            int x; read(x); a.push_back(x);
        }
        int ans=0;
        while (a.size()>0) {
            set<int> b=dp0(a,0), c=dp0(a,1);
            if (b.size()<c.size()) {
                b = c;
            } vector<int> t;
            for (int i:b) prt(a[i]); cout<<endl;
            for (int i=0;i<a.size();i++) if(b.count(i)==0) {
                t.push_back(a[i]); //a.erase(a.begin()+i);
            }
            a=t;
            ans++;
        }
        cout<<ans<<endl;
    }
}