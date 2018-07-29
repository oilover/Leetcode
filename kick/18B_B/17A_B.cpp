#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr<<#k" = "<<k<<endl;
typedef long long LL;
const int INF = 0x3f3f3f3f;
void read(int &x) { scanf("%d",&x);  }
const int MAXN = 289;
int R,C, H[MAXN][MAXN];
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
bool vis[MAXN][MAXN];
struct P
{
    int H, x, y;
    bool operator< (P p) const
    {
        if(H-p.H) return H < p.H;
        if (x-p.x) return x<p.x;
        return y<p.y;
    }
};
set<P> S,T;
bool OK(int x, int y)
{
    for (int i=0;i<4;i++) {
        int xx = x+dx[i], yy = y+dy[i];
        if (H[xx][yy] < H[x][y]) return false;
    }
    return true;
}
void Gao(int x, int y)
{
    vis[x][y] = true;
    P p = (P){H[x][y], x, y};
    S.insert(p);
    T.erase(p);
    for (int i=0;i<4;i++) {
        int xx = x+dx[i], yy = y+dy[i];
        P p = (P){H[xx][yy], xx, yy};
        if (S.find(p)!=S.end()) continue;     //printf("gao: (%d,%d)", p.x,p.y);
        T.insert(p);
    }
}
void print(set<P> S)
{
    for (P p: S) {
        printf(" (%d,%d)", p.x,p.y);
    } cout<<endl;
}
int GetMin(set<P> S)
{
    return (*S.begin()).H;
}
int GetMax(set<P> S)
{
    return (*S.rbegin()).H;
}
int main()
{
    int _,ca=1; cin>>_;
    while (_--) {
        cin>>R>>C;
        int all_min = INF;
        for (int i=0;i<R;i++) for (int j=0;j<C;j++) {
            read(H[i][j]); all_min = min(all_min, H[i][j]);
        }
        for (int i=0;i<R;i++) for (int j=0;j<C;j++) {
            H[i][j] -= all_min;
        }

        int ans = 0;
        memset(vis, false, sizeof vis);
        for (int i=1;i<R-1;i++) for (int j=1;j<C-1;j++) if (OK(i,j) && !vis[i][j]){
            S.clear(); T.clear();
          //  S.insert((P){H[i][j], i,j});
            Gao(i,j);
            int now = (*T.begin()).H - (*S.rbegin()).H; int steps=0;
            while (!T.empty() && steps++<R*C) {
                P p = *T.begin();
                int T_min = p.H;   //  print(S); print(T);
                if (p.x==0||p.x==R-1 || p.y==0||p.y==C-1) {
                    break;
                }
                Gao(p.x,p.y);
                if (GetMax(S) > GetMin(T)) break;
                now += (GetMin(T) - T_min) * S.size();
            }
            ans += now;
        }
        cout << "Case #" << ca++ << ": " << ans << endl;
    }
}
