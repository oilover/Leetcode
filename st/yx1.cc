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
const LL mod = 100003;
 
LL gao(vector<int>& a, vector<int>& b, vector<int>& c) {
    int n=a.size(), m=b.size();
    c.clear();
  //  vector<int> c(n+m);
    LL res = 0;
    int i,j,k;
    i=j=k=0;
    while (i<n && j<m) {
        if (a[i]<=b[j]) {
            res += j;
            c.push_back(a[i]);
            i++;
        } else {
            c.push_back(b[j]);
            j++;
        }
    }
    if (j==m) {
        for (; i<n; i++) {
            c.push_back(a[i]);
            res += m;
        }
    } else {
        for (; j<m; j++) {
            c.push_back(b[j]);
        }
    }
    return res;
}
LL Merge(vector<int>& a) {
    int n = a.size();
    if (n==1) return 0;
    LL res = 0;
    vector<int> b(a.begin(), a.begin() + n/2);
    vector<int> c(a.begin() + n/2, a.end());
    vector<int> t;
    return Merge(b) + Merge(c) + gao(b, c, a);
}
int main(int argc, char const *argv[])
{
    int n;
    cin>>n;
    vector<int> v;
    for (int i=0;i<n;i++) {
        int x; read(x);
        v.push_back(x);
    }
    cout<<Merge(v)<<endl;
    // LL n,w;
    // while (cin>>n>>w) {
    //     cout<<(pmod(n,w) - n*pmod(n-1, w-1) % mod + mod) % mod<<endl;
    // }
    return 0;
}

