#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr<<#k" = "<<k<<endl;
typedef long long LL;
void read(int &x) { scanf("%d",&x);  }
bool used[233]; int N , K; long long P;
string ans;

string bin(long long x)
{
    if (x==0) return "0";
    string ans="";
    while (x>0) {
        ans = ans + (x&1?"1":"0") ;
        x/=2;
    }
    return ans;
}
int main()
{
    int _; cin>>_; int ca=1;
    while (_--) {
        cin>>N>> K >> P;
        ans=string(N,'0');
        memset(used,false,sizeof used);
        for (int i=0;i<K;i++) {
            int A,B,C;
            cin>>A>>B>>C; assert(A==B);assert(C==0||C==1);A--;
            used[A] = true;
            ans[A]= C==0?'0':'1';
        }
        printf("Case #%d:", ca++);
        string s = bin(P-1); //prt(ans);prt(s);
        if (P==1) { cout<<" "<<ans<<endl; continue; }
//        while (s.size()<N-K) s=s+"0";
//        reverse(s.begin(), s.end());
int j=0;
        for (int i=N-1;j<s.size()&&i>=0;i--) if (!used[i]) {
            ans[i]=s[j++];
        }
//        assert(j==N-K);
        cout<<" "<<ans<<endl;
    }
    return 0;
}
