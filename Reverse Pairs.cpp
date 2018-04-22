typedef long long LL;
#define prt(k) cout<<#k" = "<<k<<endl
class Solution {
public:
    int merge_count(vector<int>& a) {
        int n = a.size();
        if (n<=1) return 0;
        int tot = 0;
        vector<int> b(a.begin(), a.begin() + n/2);
        vector<int> c(a.begin()+ n/2, a.end());
        tot = merge_count(b) + merge_count(c);
        int bn =  b.size(), cn = c.size();
        int pos, bi, ci;
        pos = bi = ci = 0;
        int i=0,j=0;
        for (int i=0;i<bn;i++) {
            for (; j<cn&&(LL)b[i]>c[j]*2LL; j++);
            tot+=j;
        }
        for (; pos<n; pos++) {
            if (bi<bn && (ci==c.size() || b[bi]<=c[ci])) {
                a[pos] = b[bi++];
            } else {
                a[pos] = c[ci++];
            }
        }
        return tot;
    }
    int reversePairs(vector<int>& nums) {
        return merge_count(nums);
    }
};
