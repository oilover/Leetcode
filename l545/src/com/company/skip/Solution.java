package com.company.skip;

import java.util.Arrays;

public class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        double dp[][] = new double[n+1][n+1];
        for (int i=0;i<=n;i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 1e9;
            }
        }
        dp[0][0] = 0;
        for (int i=1;i<=n;i++) {
            dp[0][i] = 0;
        }
        final double EPS = 1e-8;
        for (int i=1;i<=n;i++) {
            for (int j=0;j<=i;j++) {
                if (i>j) {
                    dp[i][j] = Math.min(Math.ceil(dp[i-1][j] + dist[i-1]*1.0/speed - EPS), dp[i][j]);
                }
                if (j>0) {
                    dp[i][j] = Math.min(dp[i-1][j-1] + dist[i-1]*1.0/speed, dp[i][j]);
                }
            }
        }
        for (int j = 0; j <= n; ++j) {
            if (dp[n][j] < hoursBefore + EPS) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSkips(new int[]{1,2,3,4,5},         1000000,
        1));
        System.out.println(s.minSkips(new int[]{1,3,2}, 4, 2));
        System.out.println(s.minSkips(new int[]{7,3,5,5}, 2, 10));
        System.out.println(s.minSkips(new int[]{7,3,5,5}, 1, 10));
    }
}

