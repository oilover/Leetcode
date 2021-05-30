package com.company.skip;

import java.util.Arrays;

public class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        double dp[][] = new double[n+1][n+1];
//        Arrays.fill(dp,(double)1e9);
        for (int i=0;i<=n;i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 1e9;
            }
        }
        dp[0][0] = 0;
        for (int i=1;i<=n;i++) {
            dp[0][i] = 0;
        }
        for (int i=1;i<=n;i++) {
            for (int j=0;j<=i;j++) {
                double t1 = Math.ceil(dp[i-1][j]) + Math.ceil(dist[i-1]*1.0/speed);
                double t2 = (j>0?dp[i-1][j-1]:1e9) + dist[i-1]*1.0/speed;
                dp[i][j] = Math.min(t1, t2);
            }
        }
        if (dp[n][n]>hoursBefore) {
            return -1;
        }
        int l=0,r=n;
        while (l<r) {
            int mid=(l+r)/2;
            if (dp[n][mid] <= hoursBefore+1e-4) {
                r=mid;
            } else {
                l=mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSkips(new int[]{1,3,2}, 4, 2));
        System.out.println(s.minSkips(new int[]{7,3,5,5}, 2, 10));
        System.out.println(s.minSkips(new int[]{7,3,5,5}, 1, 10));
    }
}

