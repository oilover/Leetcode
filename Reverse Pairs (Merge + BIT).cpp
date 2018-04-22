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
typedef long long LL;
#define prt(k) cout<<#k" = "<<k<<endl
class Solution {
public:
    int lowbit(int x) { return x&-x; }
    vector<int> tree;
    void add(int x, int val) {
        while (x<tree.size()) {
            tree[x]+=val;
            x+=lowbit(x);
        }
    }
    int sum(int x) {
        int ans = 0;
        while (x>0) {
            ans += tree[x];
            x-= lowbit(x);
        }
        return ans;
    }
    int reversePairs(vector<int>& nums) {
        vector<int> a(nums);
        sort(a.begin(), a.end());
        a.erase(unique(a.begin(),a.end()), a.end());
        for (auto &x: nums) {
            x = lower_bound(a.begin(), a.end(), x) - a.begin();
            // x++;
        }
        tree = vector<int>(a.size()+10, 0);
        int n = nums.size();
        LL tot = 0;
        
        for (int i=0;i<n;i++) {
            int j = lower_bound(a.begin(), a.end(), a[nums[i]]*2LL+1) - a.begin() + 1;
            // prt(j);
            tot += i - sum(j-1); // >=j
            add(nums[i]+1, 1);
        }
        return tot;
        // return merge_count(nums);
    }
};
