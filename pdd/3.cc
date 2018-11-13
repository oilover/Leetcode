#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
int dir[4][2] = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
typedef pair<int, int> P;
class Solution
{
  private:
    set<pair<int, int>> S;

  public:
    void dfs(int x, int y)
    {
        S.insert(P(x, y));
        for (int d = 0; d < 4; d++)
        {
            int xx = x + dir[d][0], yy = y + dir[d][1];
            if (S.find(P(x, y)) == S.end() && move(d))
            {
                dfs(xx, yy);
                move((d + 2) % 4); // 回溯，走反方向
            }
        }
    }
    int area()
    {
        int x = 0, y = 0;
        S.clear();
        dfs(0, 0);
        return S.size();
    }
};
