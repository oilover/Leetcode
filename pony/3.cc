#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
// void read(int &re) { scanf("%d", &re); }
// void read(LL &re) { scanf("%lld", &re); }
const int N = 500100;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1,1,1,-1,-1};
int dy[] = {1,-1,0,0,-1,1,-1,1};
int n=15,m;
double l0,v0,l1,v1,x0,_y0,r,x1,_y1;
const double PI = acos(-1.0);
int main(int argc, char const *argv[])
{
    int _; cin>>_;
    while (_--) {
        cin>>l0>>v0>>l1>>v1 >>x0>>_y0>>r>>x1>>_y1;
        int t = x1-x0+r;
        double len0 = 1.0* l0 / v0 , len1 = 1.0 * l1 / v1;
        if (x1>=x0-r) {
            double arc = acos(1.0*t/r)*r;
            double start = arc / v0;
            double len0 = 1.0* l0 / v0;
            double yy = _y0 + sqrt(r*r - t*t);
            double start1 = 1.0 * (_y1 - yy) / v1;
            if (start > start1+len1 || start1 > start+len0) {
                puts("No");
            } else {
                puts("Yes");
            }
        } else {
            t = x0-r - x1;
            double start = (PI/2.0*r + t) / v0;
            double start1 = 1.0*(_y1-_y0-r) / v1;
            if (start > start1+len1 || start1 > start+len0) {
                puts("No");
            } else {
                puts("Yes");
            }
        }
    }
    return 0;
}
