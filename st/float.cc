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
union uu {
    double val;
    unsigned char c[4];
} u;
int main(int argc, char const *argv[])
{
    double x = 2.25;
    // int x = 0x5789;
    auto p = (unsigned char*) &x;
    u.val = 1.75;
    for (int i=0;i<4;i++) printf("%4d", u.c[i]);
    // printf("%4x", 16);
    for (int i=0;i<4;i++) printf("%4x", p[i]);
    return 0;
}
