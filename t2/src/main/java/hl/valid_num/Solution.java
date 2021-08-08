package hl.valid_num;

import java.util.HashMap;

public class Solution {
    boolean isE(char ch) {
        return ch=='e'||ch=='E';
    }
    boolean isSign(char ch) {
        return ch=='+'|| ch=='-';
    }
    String isValid(String s) {
        return s+" "+isValidScientific(s);
    }
    boolean isNumber(String s) {
        return isValidScientific(s);
    }
    boolean isValidScientific(String s) {
        char[] num = s.toCharArray();
        int n = s.length();
        boolean hasE = false;
        if (s.isEmpty() || ".".equals(s)) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (isE(num[i])) {
                if (hasE) {
                    return false;
                }
                hasE = true;
            }
        }
        if (isE(num[n-1])) {
            return false;
        }
        boolean exp = false;
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = num[i];
            if (!isE(ch) && !Character.isDigit(ch) && ch!='.'&& !isSign(ch)) {
                return false;
            }
            if (i>0 && (ch=='+' || ch=='-') && !isE(num[i-1])) { // 符号必须在首位
                return false;
            }
            cnt.put(ch, cnt.getOrDefault(ch,0)+1);
            if (ch=='.' ) {
                if (exp) {// 指数必须整数，前面有e非法
                    return false;
                }
                if (i>2 && hasE) { // 如果有e，基数整数部分小于10，小数点必须在前三位
                    return false;
                }
                // 小数点前面或后面必须是数字
                if (!(i>0 && Character.isDigit(num[i-1])) && !(i<n-1&&Character.isDigit(num[i+1]))) {
                    return false;
                }
                if (cnt.getOrDefault('.',0)>1) {
                    return false;
                }
//                if (i==2 && hasE && !isSign(num[0])) { // 如果有e，基数整数部分小于10 23e23非法
//                    return false;
//                }
            }
            if (isE(num[i])) {
                if (i==0 ) { // 2.e3 +e 非法  e前面必须是.或数字
                    return false;
                }
                if (isSign(num[i-1])) {
                    return false;
                }
                if (exp) { // e 只能出现一次
                    return false;
                }
                exp = true;
                continue;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("005047e+6"));
        System.out.println(s.isValid("+E3"));
        System.out.println(s.isValid(".e1"));
        System.out.println(s.isValid("46.e3"));
        System.out.println(s.isValid(".3"));
        System.out.println(s.isValid("4."));
        System.out.println(s.isValid("+."));
        System.out.println(s.isValid("14."));
        System.out.println(s.isValid("e"));
        System.out.println(s.isValid("2e3"));
        System.out.println(s.isValid("0.2e3"));
        System.out.println(s.isValid("0.2e"));
        System.out.println(s.isValid("2e."));
        System.out.println(s.isValid("2e3e4"));
        System.out.println(s.isValid("2.3.2"));
        System.out.println(s.isValid("+2.7e82"));
        System.out.println(s.isValid("+.7e82"));
        System.out.println(s.isValid("+1.7E8e2"));
        System.out.println(s.isValid("+1.7E812"));
        System.out.println(s.isValid("+21.7e82"));
        System.out.println(s.isValid("+21.7e82 "));
    }
}
