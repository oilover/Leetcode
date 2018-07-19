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
bool vis[N];
struct Edge
{
    int to,next;
} edge[MAXM];
int head[MAXN], tot;
void init()
{
    tot = 0;
    memset(head,-1,sizeof(head));
    memset(vis,false,sizeof vis);
}
bool dfs(int u, int start, vector<int> &path)
{
    if (vis[u])
        return false;
    vis[u] = true;     prt(u);
    for (int i=head[u]; ~i; i=edge[i].next)
    {
        int v = edge[i].to;  //prt(v);
        if (v==start)
        {
            puts("cycle find!!");
            cycle = path;
            return true;
        }
        path.push_back(v);
        if (dfs(v,start,path))
        {
            puts("dfs");
            return true;
        }
        path.pop_back();
        vis[v] = false;
    }
    return false;
}
void addedge(int u,int v)
{
    edge[tot].to = v;
    edge[tot].next = head[u]; head[u] = tot++;
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
            memset(Graph::vis,false,sizeof Graph::vis);
            vector<int> vec;  prt(i); vec.push_back(i);
            if (Graph::dfs(i,i,vec)) {
                break;
            }
            cout<<endl;
        }
        for (auto x: cycle) {
            printf("%4d",x);
        } cout<<endl;
    }
}
