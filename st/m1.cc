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

int C(int n, int m) {
    int ans = 1;
    for (int i=1;i<=m;i++) ans = ans * (n-i+1) / i;
    return ans;

}
int main(int argc, char const *argv[])
{
    int n,m;
    while (cin>>n>>m) {
        cout<<C(n+m,m)<<endl;
    }
    return 0;
}
