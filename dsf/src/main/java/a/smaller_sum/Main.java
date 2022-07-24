package a.smaller_sum;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] smallerSum(int[] a) {
        int n = a.length;
        int[][] b = new int[n][2];
        for (int i = 0; i < n; i++) {
            b[i][0] = a[i];
            b[i][1] = i;
        }
        Arrays.sort(b, Comparator.comparingInt(x -> x[0]));
        int[] sum = new int[n + 1];
        int[] sum2 = new int[n + 1];
        sum[0] = a[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + a[i];
        }
        int lastSmaller = -1;
        for (int i = 1; i < n; i++) {
            if (a[i] > a[i - 1]) {
                lastSmaller = i - 1;
            }
            if (lastSmaller >= 0) {
                sum2[i] = sum[lastSmaller];
            }
        }
        return sum2;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.smallerSum(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(s.smallerSum(new int[]{1, 2, 2, 5})));
    }
}
