package com.hl.sliding_window.k_distinct_longest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s,int k) {
        int l=0,r=0;
        Map<Character,Integer> cnt = new HashMap<>();
        new ArrayList<>(5);
        int tot = 0; // 窗口内t中不同字符数
        int ans = 0;
        String res = ""; //s.substring(l,r);
        for (l=0;l<s.length();l++) {
            char ch;
            for (;r<s.length(); r++) {
                ch = s.charAt(r);
                if (!cnt.containsKey(ch) && cnt.size()==k) {
                    break;
                }
                cnt.put(ch, cnt.getOrDefault(ch,0)+1);
            }
            ans = Math.max(r-l,ans);
            ch = s.charAt(l);
            if (cnt.get(ch)==1) {
                cnt.remove(ch);
            } else {
                cnt.put(ch, cnt.get(ch)-1);
            }
        }
        return ans;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("abc",  3));
        System.out.println(solution.lengthOfLongestSubstringKDistinct("eceba",  3));
        System.out.println(solution.lengthOfLongestSubstringKDistinct("eceba",  2));
        System.out.println(solution.lengthOfLongestSubstringKDistinct("aab",  1));
    }
}
