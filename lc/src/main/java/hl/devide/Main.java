package hl.devide;

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend==0) return 0;
        if (divisor==1) {
            return dividend;
        }
        if (divisor==-1) {
            if (dividend==Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }
        int sign1 = (dividend>0 ? 1 : -1);
        int sign2 = (divisor>0 ? 1 : -1);
        int sign = 1;
        if (sign1*sign2<0) {
            sign = -1;
        }
        long a = dividend, b = divisor;
        a = Math.abs(a);
        b = Math.abs(b);
        long res = div(a,b);
        if (sign>0) {
            return (int)(res>Integer.MAX_VALUE ? Integer.MAX_VALUE : res);
        }
        return (int) -res;
    }
    private long div(long a, long b) {
        if (a<b) {
            return 0;
        }
        int res = 1;
        long tb = b;
        while (tb+tb<=a) {
            tb<<=1;
            res<<=1;
        }
        return res + div(a-tb, b);
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(Integer.MIN_VALUE, -1));
    }
}
