#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
#define prt(k) cout<<#k" = "<<k<<"  ";
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 2100;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};
const LL mod = 1e9+7;
LL d[N], dp[N][N];
int n,m;
LL pmod(LL a, LL n) {
    LL r=1;
    for (; n>0; n>>=1, a=a*a%mod) if(n&1) r=r*a%mod;
    return r;
}
static int ai;
class A {
public:

    A() {

     //   printf(" %d A", ++ai);
    }
};
int main(int argc, char const *argv[])
{
    prt(sizeof(char*));
    prt(sizeof(LL*));
    int p[] = new int[10]
//     if (make_pair('a',2)==make_pair('a',2)) puts("sadf");
//     multiset<int> ms; ms.insert(4); ms.insert(4);
//    ;ms.erase( ms.find(4)); prt(ms.size());
//     vector<int> v(100, 1);
//    prt(&v[0]); prt(v.capacity()); prt(v.size());
//     v.reserve(700); v.back
//     int x = 0;
//    prt(&v[0]); prt(&v[1]); prt(v.capacity()); prt(v.size());
    // v[678] = 45;
    // prt(v[697]);
    // v.resize(700, 20);
    // prt(v[678]);
    // vector<A> vv(50);
    // puts("======");
    // vv.resize(150);
    /*
    memset(d,0,sizeof d);
    d[0]=1;
    for (int i=1;i<N;i++) for (int j=1;j<=min(4,i);j++) d[i]=(d[i]+d[i-j])% mod;
  //  for (int i=1;i<15;i++) printf("d[%d] = %lld\n", i,d[i]);
    list<int> l;
    l.push_back(32);
    n = l[0];*/
    return 0;
}
