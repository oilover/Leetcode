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

void test() {
    vector<int> v(100, 1);
    int i = INT_MIN;
    prt(i*2);
    unsigned int j = i;
  //  if (i==INT_MAX+1) puts("OK");
    prt(j);
    prt(~i); prt(-i); prt(-i+i);
}
vector<int> gao(string& s) {
    vector<int> ret;
    for (int i=0;i<s.size(); ) {
        int j=i;
        while (j<s.size() && s[j]==s[i]) j++;
        ret.push_back(j-i);
        i=j;
    }
    return ret;
}
int main(int argc, char const *argv[])
{
    vector<int> v(8);
    sort(v.begin(), v.end(), [](int x, int y)->(x>y));
    int &t = v.back();
    t = 8;
    prt(v.back());
    return 0;
}

两支队伍比赛,比赛方式为:每次两支队伍各派出一人对战,战力高的胜利,最后总胜利次数最多的队伍取胜,两队人数相同,
且保证每个人战力不一样,已知A队的出战顺序,问B队能否取胜. 若取胜，则输出任何一个取胜的出战顺序

vector<int> solve(vector<int> a, vector<int> b, vector<int> Aorder) {
	  vector<pair<int,int> > A, B;
    for (int i=0;i<n;i++) {
    		A.push_back(P(a[Aorder[i]], i));
        B.push_back(P(b[i],i));
    }
    sort(A.begin(), A.end(), [](x,y)->x.first>y.first);
 		sort(B.begin(), B.end());
    reverse(B.begin(), B.end());
    vector<int> Border(n, -1);
    
    int i=0,j=0;
    for (j=0;j<n;j++) if (A[j].first < B[i].first) {
    		Border[A[j].second] = B[i++].second;
    }
    if (i<=n/2) return fail;
    for (j=0;j<n;j++) if (Border[j]==-1) Border[j] = B[i++].second;
}
