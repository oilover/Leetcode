#include <iostream>
#include <bits/stdc++.h>
using namespace std;
#define prt(k) cerr << #k " = " << k << endl;
typedef long long LL;
const LL INF = 0x3f3f3f3f3f3f3f3fLL;
void read(int &x) { scanf("%d", &x); }
const int MAXN = 501289;
LL X[MAXN], arr[MAXN], N, O, D, A, B, C, M, L;
LL sum[MAXN];
void GenData()
{
    for (int i = 3; i <= N; i++)
    {
        X[i] = (A * X[i - 1] + B * X[i - 2] + C) % M;
    }
    sum[0] = 0;
    for (int i = 1; i <= N; i++)
    {
        arr[i] = X[i] + L;
        sum[i] = sum[i - 1] + arr[i];
    }
}
typedef pair<LL, int> P;
void print(P p)
{
    printf(" (%lld,%d)", p.first, p.second);
}
int main()
{
    int _, ca = 1;
    cin >> _;
    while (_--)
    {
        cin >> N >> O >> D;
        cin >> X[1] >> X[2] >> A >> B >> C >> M >> L;
        GenData();
        set<P> aset;
        LL ans = -INF;
        aset.insert(P(0, 0));
        int left = 0;
        int cnt_odd = 0;
        for (int i = 1; i <= N; i++)
        {
            aset.insert(P(sum[i], i));
            cnt_odd += arr[i] % 2;
            if (arr[i] % 2 == 1)
            {
                while (cnt_odd > O)
                {
                    cnt_odd -= arr[left + 1] % 2;
                    aset.erase(P(sum[left], left));
                    left++;
                }
            }                                            //cout<<" ---"<<i<<endl;
            auto p = aset.lower_bound(P(sum[i] - D, 0)); // last number <= D-sum[i]
            if (p == aset.end())
            {
                continue;
            }
            ans = max(ans, sum[i] - p->first);
        }
        printf("Case #%d: ", ca++);
        if (ans <= -INF)
        {
            puts("IMPOSSIBLE");
        }
        else
        {
            cout << ans << endl;
        }
    }
}
