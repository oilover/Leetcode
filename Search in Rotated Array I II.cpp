class Solution {
    int n;
public:
    int search(vector<int>& a, int target) {
        n = a.size();
        int l = 0, r = n-1;
        while (l<=r) {
            int mid = (l+r) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[l]<=a[mid]) {
                if (a[l]<=target && target<=a[mid]) {
                    r = mid-1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (a[mid]<=target && target<=a[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } 
            
        }
        return -1;
    }
};

class Solution {
    int n;
public:
    int search(vector<int>& a, int target) {
        n = a.size();
        int l = 0, r = n-1;
        while (l<=r) {
            int mid = (l+r) / 2;
            if (a[mid] == target) {
                return true; //mid;
            }
            if (a[l]==a[mid]) {
                l++;
                continue;
            }
            if (a[l]< a[mid]) {
                if (a[l]<=target && target<=a[mid]) {
                    r = mid-1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (a[mid]<=target && target<=a[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } 
            
        }
        return false;
    }
};
