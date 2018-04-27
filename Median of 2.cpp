class Solution {
public:
    double findMedianSortedArrays(vector<int>& a, vector<int>& b) { // merge a,b => A
        int n = a.size(), m = b.size();
        assert(n+m>0);  // boundary data: n==0 || m==0, n==1&&m==1
        int ans = -1;
        int l=0, r=n-1;
        int target = (n+m)/2;   // return A[target] or (A[target] + A[target-1]) / 2
        while (l<=r) {
            int x = (l+r)/2;
            int y = lower_bound(b.begin(), b.end(), a[x]) - b.begin();
            int lb = x+y; 
            y = upper_bound(b.begin(), b.end(), a[x]) - b.begin();
            int rb = x + y;
            if (lb <= target && target <= rb) {
                ans = x;
                break;
            }
            if (lb>target) {
                r = x-1;
            } else {
                l = x+1;
            }
        }
        if (ans==-1) return findMedianSortedArrays(b, a);
        int x = ans;
        if ((n+m)%2 == 1) {
            return a[x];
        } else {
            int y = lower_bound(b.begin(), b.end(), a[x]) - b.begin();
            int lb = x+y; 
            int y2 = upper_bound(b.begin(), b.end(), a[x]) - b.begin();
            int rb = x + y2;
            // assert(x>0 || y>0);
            if (lb<=target-1)
            {
                return (a[x]+b[y])/2.0;
            }            
            if (x>0 && (y==0||a[x-1]>=b[y-1])) {
                return (a[x]+a[x-1])/2.0;
            } else {
                return (a[x] + b[y-1])/2.0;
            }
        }
    }
};
