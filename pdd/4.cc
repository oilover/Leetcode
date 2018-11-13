#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
typedef pair<int, int> P;
#define prt(k) cout << #k " = " << k << "  ";

pair<int, int> minInterval(vector<vector<int>> arrs)
{
    int K = arrs.size();
    priority_queue<P, vector<P>, greater<P>> pq;
    vector<int> last(K, INT_MIN), pos(K);
    multiset<int> ms;
    pair<int, int> ans = P(-1, -1);
    for (int i = 0; i < K; i++)
        if (pos[i] < arrs[i].size())
        {
            pq.push(P(arrs[i][pos[i]++], i));
        }
    while (!pq.empty())
    {
        P cur = pq.top();
        pq.pop();
        int val = cur.first, i = cur.second;
        if (last[i]!=INT_MIN) ms.erase(ms.find(last[i]));
        ms.insert(val);
        last[i] = val;
        if (ms.size() == K)
        {
            int start = *ms.begin();
            if (val - start + 1 > ans.second - ans.first + 1)
            {
                ans = P(start, val);
            }
        }
        if (pos[i] < arrs[i].size())
        {
            pq.push(P(arrs[i][pos[i]++], i));
        }
    }
    return ans;
}
int main(int argc, char const *argv[])
{
    multiset<int> ms;
    // ms.erase(ms.find(3));
    ms.insert(2);
    ms.insert(2);
    ms.erase(ms.find(2));
    prt(ms.size());
    return 0;
}
