#include <bits/stdc++.h>
using namespace std;  
#define prt(k) cout<<#k" = "<<k<<"  ";
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
const int N = 123;
int maze[N][N];
int n,m;
int sx,sy,tx,ty;
struct Point {
    int x,y;
    int dist;
    bool operator < (Point b) const {
        return dist > b.dist;
    }
    Point(int x,int y,int d):x(x),y(y),dist(d) {}
};
int up[N][N], down[N][N], left[N][N], right[N][N];
bool vis[N][N];
bool OK(int x, int y) {
    if (!(x>=0 && x<n)) return false;
    if (!(y>=0 && y<m)) return false;
   // prt(maze[x][y]);
    return maze[x][y]==0 ;
  //  return  && (y>=0) && y<m && 
}
int solve() {
    priority_queue<Point> pq;
    pq.push(Point(sx, sy, 0));
    memset(vis, false, sizeof vis);
    vis[sx][sy] = true;
    while (!pq.empty()) {
        Point u = pq.top(); pq.pop();
        if (u.x==tx && u.y==ty) {
            return u.dist;
        }
     //   cout<<u.x<<" " <<u.y<<endl;
        
        for (int d=0;d<4;d++) {
            int nxt_x = u.x , nxt_y = u.y ;
            int step = 0;
            // cout<<dx[d]<<"__" <<dy[d]<<"  ";
            while (OK(nxt_x + dx[d], nxt_y + dy[d])) {
                nxt_x += dx[d], nxt_y += dy[d];
                step++;
            }
            // cout<<nxt_x<<"__" <<nxt_y<<endl;
            if (!OK(nxt_x,nxt_y)) continue;
            if (!OK(nxt_x,nxt_y) || (nxt_x==u.x && nxt_y==u.y) || vis[nxt_x][nxt_y]) {
                continue;
            }
            
            vis[nxt_x][nxt_y] = true;
            pq.push(Point(nxt_x, nxt_y, u.dist + step));
      //      cout<<nxt_x<<"**" <<nxt_y<<endl;
        }
    }
    return -1;
}
int main() {
    cin>>n>>m;
    cin >> sx>>sy>> tx>>ty;
    for (int i=0;i<n;i++) {
        for (int j=0;j<m;j++) { 
            cin>>maze[i][j];
        }
    }
  //  prt(OK(0,3));  prt(OK(1,4));
    cout<<solve()<<endl;
}                                         

/**
5 5 
0 4 3 2
0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0


0 4 4 4

*/