package tmp;

public class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        final int mod=(int)1e9+7;
//        int[][] dp = new int[d+1][target+1];
//        dp[0][0] = 1;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int j=1;j<=d;j++) {
            for (int k = 1; k<=f ; k++) { //
//                for (int i=target;i>=k;i--) {
                for (int i=k;i<=target;i++) {
//                    dp[j][i] = (dp[j][i]+dp[j-1][i-k])%mod;
                    dp[i] = (dp[i]+dp[i-k])%mod;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.numRollsToTarget(2,6,7));
    }
}
