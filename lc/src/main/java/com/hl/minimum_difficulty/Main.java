package com.hl.minimum_difficulty;

import java.util.Arrays;

class Solution {
    public int minDifficulty(int[] jobDifficulty, int days) {
        int n = jobDifficulty.length;
        if (n<days) {
            return -1;
        }
        int[][] dp = new int[n+1][days+1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i=0;i<=n;i++) {
            for (int j = 0; j <= days; j++) {
                dp[i][j] = (int)1e9;
            }
        }
        dp[0][0] = 0;
        int[][] max = new int[n+1][n+1];
        for (int i=1;i<=n;i++) {
            for (int j=0;j<i;j++) {
                for (int k = j; k < i; k++) {
                    max[i][j] = Math.max(jobDifficulty[k], max[i][j]);
                }
            }
        }
        for (int i=1;i<=n;i++) {
            for (int d=1;d<=i&&d<=days;d++) {
                for (int j=0;j<i;j++) {
//                    for (int k = j; k < i; k++) {
//                        ma = Math.max(jobDifficulty[k], ma);
//                    }
                    dp[i][d] = Math.min(dp[j][d-1] + max[i][j], dp[i][d]);
                }
            }
        }
        return dp[n][days];
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minDifficulty(new int[]{7,1,7,1,7,1},3));
        System.out.println(s.minDifficulty(new int[]{11,111,22,222,33,333,44,444},6));
    }
}
