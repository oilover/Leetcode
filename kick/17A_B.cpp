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
bool OK(int x, int y)
{
    for (int i=0;i<4;i++) {
        int xx = x+dx[i], yy = y+dy[i];
        if (H[xx][yy] < H[x][y]) return false;
    }
    return true;
}
struct P
{
    int H, x, y;
    bool operator< (P p) const
    {
        return H < p.H;
    }
};
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
        set<P> S,T;
        int lowest_edge = INF;
        for (int i=1;i<R-1;i++) {
            lowest_edge = min(lowest_edge, H[i][0]);
            lowest_edge = min(lowest_edge, H[i][C-1]);
        }

        for (int j=1;j<C-1;j++) {
            lowest_edge = min(lowest_edge, H[0][j]);
            lowest_edge = min(lowest_edge, H[R-1][j]);
        }
        int ans = 0;
        for (int i=1;i<R-1;i++) for (int j=1;j<C-1;j++) {
            ans += max(0, lowest_edge - H[i][j]);
        }
        cout << "Case #" << ca++ << ": " << ans << endl;
    }
}
