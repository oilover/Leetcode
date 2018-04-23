class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& a) {
        int n = a.size();
        vector<vector<int>> result;
        if (n<3) return result;
        sort(a.begin(), a.end());
        auto i = a.begin();
        auto ed = a.end();
        const int target =  0;
        for (; i<ed-2; i++) {
            if (i>a.begin() && *i==*(i-1)) continue;
            auto j = i+1;
            auto k = ed-1;
            for(;j<k;) {
                int sum=  *i+*j+*k;
                if (sum<target) {
                    j++;
                    while (j<k && *j==*(j-1)) j++;
                    continue;
                }
                if (sum>target ) {
                    k--;
                    while (k<ed-1 && k>j && *k==*(k+1)) k--;
                    continue;
                }
                result.push_back(vector<int>({*i,*j,*k}));
                j++;
                while (j<k && *j==*(j-1)) j++;
            }
        }
        return result;
    }
};
