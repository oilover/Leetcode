package com.hl.sliding_window.win_substr;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        int l=0,r=0;
        Map<Character,Integer> need = new HashMap<>();
        for (char ch: t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch,0)+1);
        }
        int numChars = need.size();
        int tot = 0; // 窗口内t中不同字符数

        int ans = s.length();//r-l;
        String res = ""; //s.substring(l,r);
        for (; r<s.length();r++) {
            char ch = s.charAt(r);
            if (!need.containsKey(ch)) {
                continue;
            }
            need.put(ch, need.get(ch)-1);
            if (need.get(ch)==0) {
                tot++;
            }
            if (tot<numChars) {
                continue;
            }
            while (l<r) {
                ch = s.charAt(l);
                if (need.containsKey(ch)) {
                    if (need.get(ch)>=0) {
                        break;
                    }
                    need.put(ch, need.get(ch)+1);
                }
                l++;
            }
            if (r-l < ans) {
                ans = r-l;
                res = s.substring(l,r+1);
            }
        }
        if (tot<numChars) {
            return "";
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("a", "aa"));
        System.out.println(solution.minWindow("sf", "asf"));
        System.out.println(solution.minWindow("sf", "sf"));
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}
