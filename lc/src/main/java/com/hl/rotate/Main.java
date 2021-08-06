package com.hl.rotate;

import java.util.Deque;

class Solution {
    public int findMin(int[] a) {
        int n = a.length;
        int l=0, r=n-1;
        while (l<r) {
            int mid = l+(r-l)/2;
            if (a[mid] < a[r]) {
                r = mid;
            } else {
                if (a[mid] > a[r]) {
                    l = mid+1;
                } else {
                    l++;
                }
            }
        }
        return a[l];
    }
    public int search(int[] a, int target) {
        int n = a.length;
        int l=0, r=n-1;
        while (l<=r) {
            int mid = l+(r-l)/2;
            if (a[mid]==target) {
                return mid;
            }
            if (a[mid]==a[r]) {
                r--;
                continue;
            }
            if (a[mid] < a[r]) {
                if (a[mid]<=target && target<=a[r]) {
                    l=mid+1;
                } else {
                    r=mid-1;
                }
            } else {
                if (a[l]<=target && target<=a[mid]) {
                    r=mid-1;
                } else {
                    l=mid+1;
                }
            }
        }
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[]{2,2,2,0,1}));
    }
}
