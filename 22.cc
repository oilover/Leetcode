#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 2031;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};

bool vis[N];
int n,m;
vector<int> G[N];
int from[N], to[N];
void dfs(int u, int s)
{
    if (vis[u]) return;
    vis[u] = true;
    from[s]++; to[u]++;
    for (int v: G[u]) {
        dfs(v, s);
    }
}
int main()
{
    cin>>n>>m;
    memset(from,0, sizeof from); memset(to,0,sizeof to);
    for (int i=0;i<m;i++) {
        int u,v;read(u); read(v);
        G[u].push_back(v);
    }
    for (int i=1;i<=n;i++) {
        memset(vis,false,sizeof vis);
        dfs(i,i);
    }
    int ans = 0;
    for (int i=1;i<=n;i++) {
      //  prt(to[i]); prt(from[i]); cout<<endl;
        if (to[i] > from[i]) ans++;
    }
    cout<<ans<<endl;
}
