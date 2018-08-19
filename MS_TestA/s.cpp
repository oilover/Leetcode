#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout << #k " = " << k << "  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
const int MAXN = 100010;
const int N = MAXN;
typedef pair<int,int> P;
int n, m;
int a[N], b[N];
vector<pair<int, int>> v;
bool cmp(P a, P b) {
    return a.second < b.second;
}
int main()
{
    while (cin >> n >> m)
    {
        int a, b;
        for (int i = 1; i <= n; i++)
        {
            read(a);read(b);
            if (a>b) b+=m; b--;
            v.push_back(make_pair(a,b));
            a+=m,b+=m;
            v.push_back(make_pair(a,b));
        }
        sort(v.begin(),v.end(), cmp);
        int s=v[0].first, e=v[0].second, cnt=1;
        for (int i=1;i<n;i++) {
            prt(v[i].first); prt(v[i].second);
            if (v[i].first>=e) {
                cnt++;
                e = v[i].second;
            }
        }
        cout<<cnt<<endl;

    }
}
/*
3
10
0 3 3 7 7 0

*/