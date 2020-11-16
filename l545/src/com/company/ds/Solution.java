package com.company.ds;

class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = key.length(), m = ring.length();
        int dp[][] = new int [n+1][m];
        int ans =  Integer.MAX_VALUE;
        for (int j=1;j<m;j++) dp[0][j] = (int)1e9;
        for (int i=1;i<=n;i++) {
            for (int j=0;j<m;j++) {
                dp[i][j] = (int)1e9;
                char target = key.charAt(i-1), cur = ring.charAt(j);
                if (target!=cur) {
                    continue;
                }
                if (target==cur) {
                    dp[i][j] = dp[i-1][j]+1;
                    continue;
                }
                int k=(j+1)%m;
                int t = 1;
                for (; k!=j&&target!=ring.charAt(k); k=(k+1)%m,t++) ;
                dp[i][j] = dp[i-1][k] + t + 1;
                for (t=1, k=(j+m-1)%m; k!=j&&target!=ring.charAt(k); k=(k+m-1)%m,t++);
                dp[i][j] = Math.min(dp[i-1][k]+t+1, dp[i][j]);
                if (i==n) {
                    ans = Math.min(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s =  new Solution();
        System.out.println(s.findRotateSteps("godding", "gd"));
    }
}
