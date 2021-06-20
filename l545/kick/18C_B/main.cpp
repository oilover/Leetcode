#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr<<#k" = "<<k<<endl;
typedef long long LL;
void read(int &x) { scanf("%d",&x);  }
typedef pair<int,int> P;
const int N = 23;
int n, a[N][N];
bool isPolygon(vector<int> edges)
{
    int m = edges.size(); if (m<3) return false;
    int sum=0, ma = 0;
    for (int x: edges) sum+=x, ma=max(ma, x);
    return ma < sum - ma;
}
int total = 0;
void solve(int mask, vector<int>& edges)
{
    if (mask+1 == (1<<n)) total += isPolygon(edges);
    for (int i=0;i<n;i++) if (!(mask>>i&1)) {
        solve(mask|1<<i, edges);
        for (int j=i+1;j<n;j++) if (!(mask>>j&1) && a[i][j]) {
            edges.push_back(a[i][j]);
            solve(mask| (1<<i) | (1<<j), edges);
            edges.pop_back();
        }
        break;
    }
}
int main()
{
    int _; cin>>_; int ca=1;
    while (_--) {
        cin>>n; for (int i=0;i<n;i++) for (int j=0;j<n;j++) cin>>a[i][j];
        printf("Case #%d:", ca++);
        total= 0;
        vector<int> vec;
        solve(0,vec);
        printf(" %d\n", total);
    }
    return 0;
}
