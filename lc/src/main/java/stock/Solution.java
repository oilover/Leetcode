package stock;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k + 1][2];
//        dp[0][0][1] = Integer.MIN_VALUE;
        {
            for (int j = 0; j <= k; j++) {
                dp[j][1] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i <= n; i++) {
//            dp[0][1] = Integer.MIN_VALUE;
            for (int j = Math.min(i - 1, k); j >= 0; j--) {
                dp[j][0] = dp[j][0];
                if (j > 0) {
                    dp[j][0] = Math.max(dp[j - 1][1] + prices[i - 1], dp[j][0]);
                }
                dp[j][1] = Math.max(dp[j][0] - prices[i - 1], dp[j][1]);
            }
            ;
        }
        int res = 0;
        for (int j = 1; j <= k; j++) {
            res = Math.max(res, dp[j][0]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(2, new int[]{
                1, 2, 4, 7}));
    }
}