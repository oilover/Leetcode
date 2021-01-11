package com.company.ds;

class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = key.length(), m = ring.length();
        int dp[][] = new int [n+1][m];
        int ans =  Integer.MAX_VALUE;
        final int INF = (int)1e9;
        for (int j=1;j<m;j++) dp[0][j] = (int)1e9;
        for (int i=1;i<=n;i++) {
            for (int j=0;j<m;j++) {
                dp[i][j] = (int)1e9;
                char target = key.charAt(i-1), cur = ring.charAt(j);
                if (target!=cur) {
                    continue;
                }
                if (dp[i-1][j]<INF) {
                    dp[i][j] = dp[i-1][j]+1;
                    continue;
                }
                int k=(j+1)%m;
                int t = 1;
                for (; k!=j&&dp[i-1][k]>=1e9; k=(k+1)%m,t++) ;
                dp[i][j] = dp[i-1][k] + t + 1;
                for (t=1, k=(j+m-1)%m; k!=j&&dp[i-1][k]>=INF; k=(k+m-1)%m,t++);
                dp[i][j] = Math.min(dp[i-1][k]+t+1, dp[i][j]);
            }
        }
        for (int j=0;j<m;j++) ans = Math.min(ans, dp[n][j]);
        return ans;
    }

    public static void main(String[] args) {
        Solution s =  new Solution();
        System.out.println(s.findRotateSteps("aaa", "aaa"));
        System.out.println(s.findRotateSteps("godding", "gd"));
    }
}
