package stock2;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n==0) {
            return 0;
        }
        int [][]dp = new int[n+1][2];
        dp[0][1] = -prices[0];
        for (int i=1;i<=n;i++) {
            dp[i][1] = Integer.MIN_VALUE;
        }
        for (int i=1;i<n;i++) {
            dp[i][0] = Math.max(dp[i-1][1] + prices[i], dp[i-1][0]);
            dp[i][1] = dp[i-1][1];
            if (i>=2) {
                dp[i][1] = Math.max(dp[i-2][0] - prices[i],  dp[i][1]);
            }
        }
        int res = 0;
        res = Math.max(res, dp[n-1][0]);
        return res;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,0,2};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(a));
    }
}