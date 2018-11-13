#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
vector<pair<int,int> > findMaxOne(vector<vector<int>> a) {
    vector<pair<int,int> > result;
    int n = a.size();
    if (n==0) return result;
    int m = a[0].size();
    int ans = m;  // ans 表示当前经过的行中第一个1的位置的最小值
    for (ans = 0; ans<m && a[0][ans]==0; ans++);
    result.push_back(make_pair(0,m-ans));
    int cur = 1;
    for (cur=1; cur<n; cur++) {
        if (a[cur][ans]==0) continue; 
        if (ans>0 && a[cur][ans-1]==1) {
            while (ans>0 && a[cur][ans-1]==1) ans--;
            result.clear();
        } 
        result.push_back(make_pair(cur, m-ans));
    }
    return result;
}