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
int n,m;
priority_queue<LL, vector<LL>, greater<LL> > Q;
multiset<LL> s, S;
void out(multiset<LL> &s) {
    for (LL x: s) prt(x); cout<<endl;
}
bool judge(LL ans) {
    s = S;
    for (int i=0;i<m;i++) {
        LL x = *s.begin();
        if (x>=ans) return true;
        if (s.size() <= 1) return false;
        auto p = s.lower_bound(ans-x);
        if (p==s.end()) return false;
        if (p==s.begin()) p++;
        if (*p >= ans) {
            p = s.begin() ;
            p++;
        }
        LL t = x + *p;
        
        s.erase(p); 
        s.erase(s.begin());
        s.insert(t);
      //  out(s);
    }
    return *s.begin() >= ans;
}
int main(int argc, char const *argv[])
{
    prt(INT_MIN);
    cin>>n>>m;
    LL x;
    for (int i=0;i<n;i++) {
        read(x); Q.push(x);
        S.insert(x);
    }
 //prt(judge(8));
    LL l = *S.begin(), r = 1e10;
    while (l<r) {
        LL mid = (l+r)/2;
        prt(l); prt(r); cout<<endl;
        if (judge(mid)) l = mid;
        else r = mid-1;
    }
    cout<<l<<endl;
    // for (int i=0;Q.size()>=2 && i<m;i++) {
    //     LL x=Q.top(); Q.pop();
    //     LL y=Q.top(); Q.pop();
    //     Q.push(x+y);
    // }
    // cout<<Q.top()<<endl;
    return 0;
}
/*
6 3
1 7 2 2 5 9

ans: 8

*/



