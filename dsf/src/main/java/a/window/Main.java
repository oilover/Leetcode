package a.window;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static final int N = 58;

    boolean ok(int[] need) {
        for (int k = 0; k < N; k++) {
            if (need[k] > 0) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String p) {
        int[] cnt = new int[N];
        int[] need = new int[N];
        for (char ch : p.toCharArray()) {
            cnt[ch - 'A']++;
        }
        for (int i = 0; i < N; i++) {
            need[i] = cnt[i];
        }
        String ans = "";
        List<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'A';
            need[ch]--;
            while (j < i && need[s.charAt(j) - 'A'] < 0) {
                need[s.charAt(j) - 'A']++;
                j++;
            }
            if (ok(need)) {
                String cur = s.substring(j, i + 1);
                if ("".equals(ans) || ans.length() > cur.length()) {
                    ans = cur;
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println('z' - 'A');
        System.out.println(s.minWindow("cbaebabacd", "abc"));
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
    }
}