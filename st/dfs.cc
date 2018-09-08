#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 100100;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
int n=10,m=10;
char a[20][20];
bool vis[89][78];
bool OK(int x, int y) {
    return 0<=x&&x<n && 0<=y&&y<m;
}
bool dfs(int x, int y) {
    vis[x][y] = true;
    for (int d=0;d<4;d++) {
        int xx=x+dx[d], yy=y+dy[d];
        if (!OK(xx,yy)) return true;
        if (a[xx][yy]=='0' && !vis[xx][yy]) {
            if (dfs(xx,yy) ) return true;
        }
    }
    return false;
}
int main(int argc, char const *argv[])
{
    memset(vis,false,sizeof vis);
    for (int i=0;i<10;i++) cin>>a[i];
    int x,y;
    cin>>x>>y;
    cout<<dfs(x,y)<<endl;
    return 0;
}
