#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int reversePairs(vector<int>& a) {
        int n = a.size();
        return solve(a, 0, n-1);
    }
    // [l, r]
    int solve(vector<int>& a, int l, int r) {
        if (l>=r) return 0;
        int ans = 0;
        int m = (l+r+1)/2; // l<m
        ans = solve(a, l, m-1) + solve(a, m, r);
        int i=l,j=m;
        for (;i<m&&j<=r; i++) {
            for (; j<=r && a[i]>2*a[j]; j++);
            ans += j-m;
        }
        vector<int> b;
        i=l,j=m;
        for (;i<m||j<=r;) {
             if (i>=m) {
                 b.push_back(a[j++]);
                 continue;
             }
             if (j>r) {
                 b.push_back(a[i++]);
                 continue;
             }
            if (a[i]<=a[j]) {
                b.push_back(a[i++]);
                continue;
            }
            b.push_back(a[j++]);
        }
        for (i=l;i<=r;i++) {
            a[i] = b[i-l];
        }
        return ans;
    }
};
int main() {
    Solution* s = new Solution();
    vector<int> a = {1,3,2,3,1};
    cout << s->reversePairs(a);
    return 0;
}
