#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
const int N = 10200;
string s;
int count(string s) {
    int n=s.size();
    int ans=0;
    if (n>=2 && s[0]=='0') ; else ans++; // No decimal point
    for (int i=1;i<n;i++) {
        if ((i>1&&s[0]=='0') || (s[n-1]=='0')) ;
        else ans++;
    }
    return ans;
}
int main() {
    while (cin>>s) {
        int n=s.size(); int ans=0;
        for (int i=1;i<n;i++) {
            ans += count(s.substr(0,i))*count(s.substr(i));
        }
        cout<<ans<<endl;
    }
}