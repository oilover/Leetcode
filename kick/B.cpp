#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr<<#k" = "<<k<<endl;
typedef long long LL;
const int INF = 0x3f3f3f3f;
typedef pair<LL,int> P;
void read(int &x) { scanf("%d",&x);  }
const int MAXN = 150289;
const int N = MAXN;
int n, K;
LL pos[N],height[N],x[N],y[N];
void get_data(LL* res, int n) {
    int a, b, c, m;
    cin >> res[1] >> res[2] >> a >> b >> c >> m;
    for (int i = 3; i <= n; ++i)
        res[i] = (1LL * a * res[i - 1] + 1LL * b * res[i - 2] + c) % m + 1;
}

void genData()
{
    get_data(pos,n);
    get_data(height,n);
    get_data(x,K);
    get_data(y,K);
}
P res[MAXN];
bool OK(P tower, P res)
{
    int i = res.second, ii = tower.second;
    return pos[i]-height[i]>= pos[ii]-height[ii];
}
bool can(LL p,LL h,LL x, LL y)
{
    return abs(x-p)<=h-y;
}
bool can(pair<LL,LL> p,LL x, LL y)
{
    return can(p.first, p.second, x,y);
}
void print(pair<LL,LL> p)
{
    cout<<" ("<<p.first<<","<<p.second<<") ";
}
int main()
{
    int _,ca=1; cin>>_;
    while (_--) {
        cin>>n>>K;
        genData();
        int ans=0;
        vector<P> vec;
        for (int i=1;i<=n;i++) {
            vec.push_back(P(pos[i]+height[i],i));
        }
        sort(vec.begin(), vec.end());
        int tot = 0;
        for (P p: vec) {
            while (tot>0 && OK(p, res[tot-1]) ) tot--;
            res[tot++] = p;
        }
        vec.clear();
        for (int i=0;i<tot;i++) {
            int id = res[i].second;
            vec.push_back(make_pair(pos[id], height[id]));
        }
        sort(vec.begin(), vec.end());
//prt(tot);
        for (int i=1;i<=K;i++) {
            bool OK = false;
            auto tmp = *vec.rbegin();
         //   print(make_pair(x[i],y[i]));cout<<":: ";
            if (x[i]<=vec[0].first) OK = can(vec[0],x[i],y[i]);
            else {
                if (x[i]>=tmp.first) OK = can(tmp,x[i],y[i]);
                else {
                    auto t = lower_bound(vec.begin(),vec.end(),make_pair(x[i],0));
                    OK |= can(*t, x[i],y[i]);
                 //   print(*t); //prt(can(*t, x[i],y[i]) );
                    t--;
                    OK |= can(*t, x[i],y[i]);
                }
            } //prt(OK);
            if (OK) ans ++; //ans += OK;
        }
        printf("Case #%d: ", ca++);
        cout<<ans<<endl;
    }
}
