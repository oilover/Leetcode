#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 5100;
typedef pair<int,int> P;

int n,m;
P a[N];
int price[N];
bool cmp(P a, P b) {
    if (a.second!=b.second) a.second > b.second;
    return a.first < b.first;
}
int main(int argc, char const *argv[])
{
    cin>>n>>m;
    set<int> pr;
    for (int i=0;i<n;i++) {
        read(price[i]); pr.insert(price[i]);
    }
    sort(price, price+n);
    for (int i=0;i<m;i++) {
        int x,y; read(x);read(y);
        a[i]=P(x,y);
    }
    sort(a,a+m,cmp);  // puts("Read OK..");
    int ans = 0;
    int j=0;
    for (int i=0; j<n && i<m;i++) {
        int sum = 0;
        while (j<n and sum<a[i].first) sum+=price[j++];
        ans += sum - a[i].second;  
        // prt(sum);
        // auto p = pr.lower_bound(a[i].first);
        // if (p==pr.end()) continue;
        // prt(*p);
        // ans += *p - a[i].second;
        //  pr.erase(p);
    }
    for (; j<n; j++) ans+=price[j];
    // for (int x: pr) ans+=x;
    cout<<ans<<endl;
    return 0;
}
