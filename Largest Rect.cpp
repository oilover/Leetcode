class Solution {
public:
    int largestRectangleArea(vector<int>& h) {
        stack<int> S;
        h.push_back(0);
        if (h.empty()) return 0;
        int ans = h[0];
        S.push(0);
        for (int i=0;i<h.size();) {
            if (S.empty() || h[S.top()]<h[i]) {
                S.push(i++);
            } else {
                int t = S.top(); S.pop();
                ans = max(ans, h[t] * (S.empty() ? i : i-S.top()-1));
            }
        }
        h.pop_back();
        return ans;
    }
};
