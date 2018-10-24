#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 100100;
typedef pair<int,int> P;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};

int main()
{
    string s;
    while (cin>>s){
        int n=s.size();
        int ans=0; string str;
        for (int i=0;i<n;i++){
            int t=2;
            int a=i,b=i+1;
            while (a>=0&&b<n&&s[a]==s[b])a--,b++,t+=2; t-=2;
            if (ans<t) { ans=t, str = s.substr(a+1,t);}
            t=1,a=b=i;
            while (a>=0&&b<n&&s[a]==s[b])a--,b++,t+=2; t-=2;
            if (ans<t) { ans=t, str = s.substr(a+1,t);}
        }
     //   prt(ans);
        cout<<str<<endl;
    }
}
