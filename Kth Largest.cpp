class Solution {
public:
    int findK(vector<int>& a, int l, int r, int k) {
        int len=  r-l+1;
        int pivot = rand() % len + l;
        swap(a[pivot], a[r]);
        int x = a[r];
        int j = l-1;
        for (int i=l;i<r;i++) {
            if (a[i]>x) {
                swap(a[++j], a[i]);
            }
        }
        swap(a[++j], a[r]);
        int left = j-l+1;
        if (k==j-l+1) return a[j];
        if (k>left) return findK(a, j+1,r, k-left);
        return findK(a,l, j, k);
    }
    int findKthLargest(vector<int>& nums, int k) {
        srand(time(NULL));
        return findK(nums, 0, nums.size()-1, k);
    }
};
