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
const LL INF = 1e18;
int n,m;
map<char, int> mp;
int a[223][233];
bool OK(int x, int y) {
    return 0<=x&&x<n && 0<=y&&y<m;
}
int main(int argc, char const *argv[])
{
    mp['C'] = 1; mp['M']=2; mp['Y'] = 4;
    mp['R'] = 6; mp['G']=5; mp['B'] = 3; mp['W'] = 0; mp['b'] = 7;
    int _; cin>>_; 
    while (_--) {
        cin>>n>>m;
        for (int i=0;i<n;i++) for (int j=0;j<m;j++) {
            string s; cin>>s;
            a[i][j] = mp[s[0]];
        }
        for (int i=0;i<n;i++) for (int j=0;j<m;j++) {
            int x=a[i][j];
            if (x&(x-1)) { // combined
                bool can = false;
                for (int d=0;d<4;d++) {
                    int xx=x+dx[d], yy=y+dy[d];
                    if (!OK(xx,yy) || a[xx][yy]==0) can=true;
                    
                }
                continue;
            }

        }
    }
    return 0;
}
