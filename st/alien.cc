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
int n;
int a[N];
int main(int argc, char const *argv[])
{
    map<int,int> id;
    cin>>n;
    for (int i=0;i<n;i++) {
        int x; read(x);
        id[x] = i;
    }
    for (int i=0;i<n;i++) {
        read(a[i]);
        a[i] = id[a[i]];
    }
    int ans = 0;
    for (int i=0;i<n;i++) {
        for (int j=i+1;j<n;j++) if (a[i]>a[j]) ans++;
    }
    cout<<ans<<endl;
    return 0;
}
