#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 500100;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1,1,1,-1,-1};
int dy[] = {1,-1,0,0,-1,1,-1,1};
int n=15,m;
char s[33][33];
bool in(int x, int y) {
    return 0<=x && x<15 && 0<=y && y<15;
}
bool OK(int x, int y, int d) {
    if (s[x][y]=='.') return false;
    for (int i=1;i<5;i++) {
        int xx = x + i*dx[d], yy = y+ i*dy[d];
        if (!in(xx,yy) || s[xx][yy]!=s[x][y]) return false;
    }
    return true;
}
// bool OK(int x, int y) {
//     for (int d=0;d<8;d++) if (OK(x,y,d)) return true;
//     return false;
// }
int main(int argc, char const *argv[])
{
    for (int i=0;i<15;i++) cin>>s[i];
    string winner = ".";
    bool draw = true;
    bool invalid = false;
    int B = 0, W=0;
    for (int i=0;i<n;i++) for (int j=0;j<n;j++) if (s[i][j]!='.') {
        
        if (s[i][j]=='B') B++; else W++;
        for (int d=0;d<8;d++) {
            if (OK(i,j,d)) {
                if (winner!=".") {
                    invalid = true;
                    break;
                }
                winner = s[i][j]=='B' ? "black" : "white";
            }
        }
    } else draw = false;
    if (B==W || B==W+1); else invalid = true;
    if (winner!=".") {
        if (winner=="black") {
            if (B==W+1); else invalid = true;
        } else {
            if (B==W); else invalid = true;
        }
    }
    if (invalid) {
        puts("invalid board");
        return 0;
    }
    if (draw && winner==".") {
        puts("draw"); return 0;
    }
    if (winner==".") puts("not finished");
    else cout<<winner + " win\n";
    return 0;
}
