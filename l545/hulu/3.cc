#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 500100;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
int n,m,k;
set<int> G[N];
int d[N];
struct Node {
    int d, id, day;
    Node(int d, int id, int day=0):d(d),id(id),day(day) {}
    bool operator < (Node b) const {
        if (d-b.d) return d>b.d;
        return id > b.id;
    }
};
int main(int argc, char const *argv[])
{
    memset(d,0,sizeof d);
    cin>>m>>n>>k;
    for (int i=0;i<k;i++) {
        int x,y; read(x); read(y);
        G[y].insert(x);
        d[x]++;
    }
    priority_queue<int, vector<int>, greater<int> > pq;
    int ans = 0;
    for (int i=1;i<=m;i++) if (d[i]==0) {
        pq.push(i);
    }
    bool OK = true;
    int cnt = 0;
    while (!pq.empty()) {
        ans++;
        vector<int> v;
        for (int i=0;i<n;i++) if (!pq.empty() ) {
            int u = pq.top(); pq.pop(); cnt++;
            for (int x: G[u]) {
                if (--d[x]==0) {
                    v.push_back(x);
                }

            }
        } else break;
        for (int x: v) pq.push(x);
    }
  //  prt(cnt);
    if (cnt<m) puts("E"); else cout<<ans<<endl;
    return 0;
}
