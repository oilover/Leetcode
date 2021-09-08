#include <bits/stdc++.h>
using namespace std;
#define prt(k) cout<<#k" = "<<k<<"  ";
typedef long long LL;
void read(int &re) { scanf("%d", &re); }
void read(LL &re) { scanf("%lld", &re); }
const int N = 100100;
typedef pair<char,int> P;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};

int main(int argc, char const *argv[])
{
    map<char,int> cnt;
    cnt['a']=34;
    prt(cnt.size());
    string s;
    while (cin>>s) {
        map<char,int> mp;
        for (auto c:s) mp[c]++;
        int mi = 233;
        vector<P> v;
        for (auto c: mp) mi=min(mi, c.second);
        string ans="";
        for (auto c: s) if (mp[c]>mi) ans+=string(1,c);
        cout<<ans<<endl;
    }
    return 0;
}
