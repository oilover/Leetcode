#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
const int N = 208;
int dir[4][2] = {{0,1},{1,0},{0,-1},{-1,0}};

int n,m; LL k;
long long  C[N][N];
int main(int argc, char const *argv[])
{
    C[0][0]=1;
    for (int i=0;i<N;i++) for (int j=0;j<=i;j++) {
        if (i==0 || j==0) C[i][j]=1;
        else C[i][j]=C[i-1][j-1] + C[i-1][j];
        if (C[i][j] > (LL)1e9) C[i][j]=1e9;
    } //prt(C[3][1]);
    while (cin>>n>>m>>k) {
        k--;
        string ans(n+m,'a'); //prt(ans);
        int t = n+m;
        bool err = false;
        for (int i=0;i<t;i++) {
            
            if (n==0) {
                if (m==0) {
                    err=true; break;
                }else {
                     ans[i]='z', m--;
                     continue;
                }

            }
            LL num = C[t-i-1][n-1]; //prt(t-i-1); prt(n-1);
            if (n>0 && k<num) {
                ans[i] = 'a', n--;
            }
            else {
                if (m>0) {

                    ans[i]='z', m--;
                    k-=num;
                }
                else {
                    err=true; break;
                }
            } 
         //   prt(num); prt(k); cout<<endl;
        }
       // if (!err && n==0&&m==0&&k==0)
        if (err) puts("-1");
        else cout<<ans<<endl;
    }
    return 0;
}
