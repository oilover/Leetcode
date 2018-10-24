#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 3100;
typedef pair<int,int> P;
template <class T>
void print(vector<T> v) {
    for (auto x: v) cout<<" "<<x; cout<<endl;
}
int n,m;
multiset<int> v[N];
bool cmp(multiset<int> a, multiset<int> b) {
    return a.size() > b.size();
}
void ehead(multiset<int>& ms) {
    ms.erase(ms.begin());
}
int f(const multiset<int> &ms) {
    return *ms.begin();
}
int main(int argc, char const *argv[])
{
    /* code */
    cin>>n>>m;
    for (int i=0;i<n;i++) {
        int x, y; read(x); read(y);
        v[x].insert(y);
    }
    int now = v[1].size();
  //  sort(v+2, v+m+1, cmp);
    multiset<int> heads;

    LL ans = 0;
    while (true) {
        int maxid = 2;
        for (int i=3;i<=m;i++) if (!v[i].empty()) {
            if (v[i].size() > v[maxid].size() ||
                (v[i].size() == v[maxid].size() && f(v[i]) < f(v[maxid]) ) ) {
                    maxid = i;
                }
        }
        if (v[maxid].size() < now) break;
        vector<P> tmp;
        for (int i=2;i<=m;i++) if (!v[i].empty() && i!=maxid) {
            tmp.push_back(P(f(v[i]) ,i)) ;

        }
        for (int i=2;i<=m;i++) if (!v[i].empty() && i!=maxid) {
            tmp.push_back(P(f(v[i]) ,i)) ;

        }
        sort(tmp.begin(), tmp.end());
        if (tmp.size()>=2 && tmp[0].first + tmp[1].first < f(v[maxid])) {
            int t = tmp[0].second;
            v[t].erase(v[t].begin());
            t = tmp[1].second;
            v[t].erase(v[t].begin());
            ans += tmp[0].first +tmp[1].first;
            now += 2;
        } else {
            ans += f(v[maxid]);
            ehead(v[maxid]);
            now ++;
        }
    }
    cout<<ans<<endl;
    return 0;
}
