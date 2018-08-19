#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
const int N = 102100;
int dir[4][2] = {{0,1},{1,0},{0,-1},{-1,0}};

int n,k;
int s[N],a[N],wake[N], sum;
int main(int argc, char const *argv[])
{
    while (cin>>n>>k) {
        s[0] = 0; sum=0;
        for (int i=1;i<=n;i++) {
            read(a[i]); //s[i]=s[i-1]+a[i];

        }
        for (int i=1;i<=n;i++) {
            read(wake[i]);
            if (wake[i]==0) s[i]=s[i-1]+a[i];
            else s[i]=s[i-1], sum+=a[i];
        }
        int ans = 0;
        for (int i=1;i<=n;i++) {
            ans=max(ans, s[i]-s[max(i-k,0)]);
        }
        ans+=sum;
        cout<<ans<<endl;
    }
    return 0;
}
