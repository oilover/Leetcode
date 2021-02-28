package com.hl.threesum;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2));
//        HashSet<Integer> hs; hs.
        PriorityQueue<Integer> maxheap;
        maxheap = new PriorityQueue<>((x, y) -> y - x);
        Arrays.sort(a);
        int n = a.length;
        for (int i=0;i<n-2&&a[i]<=0;i++) {
            if (i>0&&a[i]==a[i-1]) continue;
            int l=i+1,r=n-1;
            while (l<r) {
                if (l>i+1 && a[l]==a[l-1]) {
                    l++;
                    continue;
                }
                if (r<n-1&& a[r]==a[r+1]) {
                    r--;
                    continue;
                }
                int sum = a[i]+a[l]+a[r];
                if (sum==0) {
                    res.add(new ArrayList<>(Arrays.asList(a[i],a[l],a[r])));
                    l++;
                } else {
                    if (sum<0) {
                        l++;
                    }else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}

