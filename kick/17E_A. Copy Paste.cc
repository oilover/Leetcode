#include <iostream>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr<<#k" = "<<k<<endl;
typedef long long LL;
void read(int &x) { scanf("%d",&x);  }
string str; int n;
int dp[323];
int main()
{
    int _; cin>>_; int ca=1;
    while (_--) {
        cin>>str;
        memset(dp,63,sizeof 63);
        n = str.size(); dp[0] = 1;

        for (int i=1;i<n;i++) {
            dp[i] = min(dp[i], dp[i-1]+1);
            for (int j=i/2;j<i;j++) {
                int L=i-j+1;
                int t = j; int pasteNum = 1;
                string pattern = str.substr(j,L);
                while (t-L>=0 && str.substr(t-L,L)==pattern) { 
                    t-=L;
                    pasteNum++;
                }
                string tmp = str.substr(0,t);
                if (tmp.find(pattern)>=0) {
                    dp[i] = min(dp[i], dp[t-1] + pasteNum+1);
                } else {
                    dp[i]=min(dp[i], dp[t+L-1] + pasteNum);
                }
            }
        }
        cout<<" "<<dp[n-1]<<endl;
    }
}
