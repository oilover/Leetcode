#include <bits/stdc++.h>
#define prt(k) cout<<#k" = "<<k<<endl
typedef long long LL;
int read(int &re) { return scanf("%d", &re); }
using namespace std;

const int N = 123;
vector<int> a[N];
int n,Dep,leaf;

int leaves[N];
int leafID[N], sz[N], D[N][N], father[N], dep[N];
int ch[N];
vector<int> nonleaf[N];
bool is_leaf[N];
int getD(int i,int j) {
    return D[leafID[i]][leafID[j]];
}
int getLeafCh(int u)
{
    while (!is_leaf[u] && ch[u]-u) u=ch[u];
}
bool same(int i, int j)
{
    return getD(ch[i],ch[j]) == dep[ch[i]]+dep[ch[j]]-dep[i]-dep[j] + 2;
}
int main()
{
    cin>>n>>Dep>>leaf;
    for (int i=1;i<=Dep;i++) {
        cin>>sz[i];
    }
    for (int i=1;i<=Dep;i++) {
        for (int j=0;j<sz[i];j++) {
            int x; cin>>x;
            dep[x] = i;
            ch[x] = x;
            a[i].push_back(x);
        }
    }
    memset(is_leaf,false,sizeof is_leaf);
    for (int i=0;i<leaf;i++) {
        int x; cin>>x;
        leaves[i] = x;
        leafID[leaves[i]] = i;
        is_leaf[x] = true;
    }
    for (int i=0;i<leaf;i++) {
        for (int j=0;j<leaf;j++) {
            scanf("%d", &D[i][j]);
        }
    }
    vector<int> last_nonleaf;
    int left_leaf = -1; //same row
    int root = a[1][0];
    father[a[1][0]] = 0;
    last_nonleaf.push_back(a[1][0]);
    for (int i=1;i<=Dep;i++) {
        for (int x:a[i]) {
            if (!is_leaf[x]) nonleaf[i].push_back(x);
        }
    }
    for (int i=Dep;i>=2;i--) {
        vector<int> new_nonleaf;
        int pp=  0;
        int left = -1;
        for (int x:a[i]) {
            if (left== -1 || same(left,x)) {
                father[x] = nonleaf[i-1][pp];
            }
            else {
                father[x] = nonleaf[i-1][++pp];
            }

            ch[father[x]] = ch[x];
            left = x;
        }
    }
    printf("%d", father[1]);
    for (int i=2;i<=n;i++) printf(" %d",father[i]);
}
