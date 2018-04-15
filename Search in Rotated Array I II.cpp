class Solution {  // I. 
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

class Solution {  // II. duplicate
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
#define prt(k) cout<<#k" = "<<k<<endl
class Solution {  // 153. Find Minimum in Rotated Sorted Array
public:
    int findMin(vector<int>& a) {
        int n = a.size();
        if (n==1) return a[0];
        int l = 0, r = n-1;
        while (l<r) {
            int mid = (l+r) / 2;
            // prt(mid);
            if (a[l]<=a[r]) {
                return a[l];
            }
         //  if (mid>0 && a[mid-1]<a[mid])
            if (a[r]< a[l] && a[l]<= a[mid]) {
                l = mid+1;
            } else if (a[r]<a[l] && a[mid]<=a[r]){
                r = mid;
                // prt(r);
            } 
            
        }
        return a[l];
    }
};
