package a.anagram;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static final int N = 26;
    boolean ok(int[] need) {
        for (int k = 0; k < N; k++) {
            if (need[k] != 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[N];
        int[] need = new int[N];
        for (char ch : p.toCharArray()) {
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < N; i++) {
            need[i] = cnt[i];
        }
        List<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            need[ch]--;
            while (j < i && need[s.charAt(j) - 'a'] < 0) {
                need[s.charAt(j) - 'a']++;
                j++;
            }
            if (ok(need)) {
                res.add(j);
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println('z'-'A');
        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
    }
}
