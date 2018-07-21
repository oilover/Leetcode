#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr<<#k" = "<<k<<endl;
typedef long long LL;
void read(int &x) { scanf("%d",&x);  }
typedef pair<int,int> P;
const int N = 23;
int n, a[N][N];
vector<P> edges;
int getEdgeLen(P p) {
    return a[p.first][p.second];
}
vector<P> getEdgeSet(int s)
{
    vector<P> vec;
    for (int i=0;i<edges.size();i++) if (s>>i & 1) vec.push_back(edges[i]);
    return vec;
}

bool OK(vector<P> edges)
{
    int m = edges.size();
    map<int,int> endpoints;
    for (P e: edges) {
        endpoints[e.second]++; endpoints[e.first]++;
    }
    for (P e : edges) {
        if (endpoints[e.first]>1 || endpoints[e.second] > 1) return false;
    }
    return true;
}
bool isPolygon(vector<int> edges)
{
    int m = edges.size(); if (m<3) return false;
    for (int i=0;i<m;i++) {
        int other_sum = 0;
        for (int j=0;j<m;j++)if(i-j) {
            other_sum+=edges[j];
        }if (edges[i] >= other_sum) return false;
    }
    return true;
}
bool isPolygon(vector<P> edges)
{
    vector<int> v; for (P p: edges) v.push_back(getEdgeLen(p));
    return isPolygon(v);
}
int main()
{
    int _; cin>>_; int ca=1;
    while (_--) {
        cin>>n; for (int i=0;i<n;i++) for (int j=0;j<n;j++) cin>>a[i][j];
        printf("Case #%d:", ca++);
        edges.clear();
        for (int i=0;i<n;i++) for (int j=i+1;j<n;j++) if (a[i][j]) {
            edges.push_back(P(i,j));
        }
        int m=edges.size();
        int total = 0;
        for (int i=0;i<(1<<m);i++) {
            vector<P> e=getEdgeSet(i);
            if (OK(e) && isPolygon(e)) {
                total++;
            }
        }
        printf(" %d\n", total);
    }
    return 0;
}
