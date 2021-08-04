package com.hl.atoi;

class Solution {
    public int myAtoi(String s) {
        s = s.replaceAll("^[ ]+", "");
        boolean neg = false;
        if (s.isEmpty()) {
            return 0;
        }
        if ('-' == s.charAt(0)) {
            neg = true;
        }
        long res = 0;
        int start = 0;
        char ch = s.charAt(0);
        if (ch=='+' || ch=='-') {
            start = 1;
        }
        for (int i=start;i<s.length();i++) {
            ch = s.charAt(i);
            if( !Character.isDigit(ch)) {
                break;
            }
            if (!Character.isDigit(ch)) {
                if (ch=='-') {
                    neg=!neg;
                }
                continue;
            }
            if ((!neg && res<Integer.MAX_VALUE) || (neg && res<-(long) Integer.MIN_VALUE)) {
                res = res * 10 + ch - '0';
            }
        }
        if (neg) {
            res = -res;
        }
        if (res>Integer.MAX_VALUE) {
            res = Integer.MAX_VALUE;
        }
        if (res<(long) Integer.MIN_VALUE) {
            res = Integer.MIN_VALUE;
        }
        return (int)res;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("   +0 123"));
        System.out.println(s.myAtoi("   -42"));
        System.out.println(s.myAtoi("4193 with words"));
        System.out.println(s.myAtoi("21474836473th words"));
        System.out.println(s.myAtoi("-2147483648 words"));
        System.out.println(s.myAtoi("-2147483649 words"));
        System.out.println(" sf \n      f ".replaceAll("\\s",""));
        System.out.println("   -42 ".replaceAll("\\s",""));
    }
}
