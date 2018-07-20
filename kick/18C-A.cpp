#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
const int N = 2100;
const int MAXN = N;
const int MAXM = N*4;
int n;
vector<int> cycle;
namespace Graph
{
    bool edge_used[N][N];
    bool getEdge(int u,int v) {
        if (u<0 || v<0) return false;
        return edge_used[u][v];
    }
    void setEdge(int u,int v, bool ok) {
        if (u<0 || v<0) return;
        edge_used[u][v] = edge_used[v][u] = ok;
    }

struct Edge
{
    int to,next;
} edge[MAXM];
int head[MAXN], tot;
void init()
{
    tot = 0;
    memset(head,-1,sizeof(head));
}
bool dfs(int u, int prev, int start, vector<int> &path)
{
    for (int i=head[u]; ~i; i=edge[i].next)
    {
        int v = edge[i].to;  //prt(v);
        if (v==prev) continue;
        if (getEdge(v,u)) continue;
        if (v==start)
        {
            puts("cycle find!!");
            cycle = path;
            return true;
        }
        path.push_back(v);
        setEdge(u,v,true);
        if (dfs(v,u, start,path))
        {
            return true;
        }
        path.pop_back();
        setEdge(u,v,false);
    }
    return false;
}
void addedge(int u,int v)
{
    edge[tot].to = v;
    edge[tot].next = head[u]; head[u] = tot++;
}
bool vis[N];
int dis[N];
void BFS()
{
    queue<pair<int,int> > Q;
    memset(vis,false,sizeof vis);
    for (int x: cycle) {
        Q.push(make_pair(0,x));
        dis[x] = 0;
        vis[x] = true;
    }
    while (!Q.empty()) {
        int cur = Q.front().second; int cur_dis=Q.front().first; Q.pop();
        dis[cur] = cur_dis;  prt(cur);
        for (int i=head[cur];~i;i=edge[i].next) {
            int to = edge[i].to;
            if (vis[to]) continue;
            Q.push(make_pair(cur_dis+1,to));
            vis[to] = true;
        }
    }
    printf("dis: ");
        for (int i=1;i<=n;i++) {
            printf("%4d",dis[i]);
        } cout<<endl;
}
}

int main()
{
    int _; cin>>_;
    while (_--) {
        cin>>n;
        Graph::init();
        for (int i=1;i<=n;i++) {
            int u,v; scanf("%d%d",&u,&v);
            Graph::addedge(u,v);
            Graph::addedge(v,u);
        }
        for (int i=1;i<=n;i++) {
            vector<int> vec;  prt(i); vec.push_back(i);
            memset(Graph::edge_used,false,sizeof Graph::edge_used);
            if (Graph::dfs(i,-1,i,vec)) {
                break;
            }
            cout<<endl;
        }  printf("cycle: ");
        for (auto x: cycle) {
            printf("%4d",x);
        } cout<<endl;
        Graph::BFS();

    }
}
/**
2
5
1 2
2 3
3 4
2 4
5 3

3
1 2
3 2
1 3
*/
