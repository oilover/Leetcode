package com.hl.sliding_window.k_distinct;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String lengthOfLongestSubstringKDistinct(String s,int k) {
        int l=0,r=0;
        Map<Character,Integer> cnt = new HashMap<>();
//        for (char ch: t.toCharArray()) {
//            cnt.put(ch, cnt.getOrDefault(ch,0)+1);
//        }
        int tot = 0; // 窗口内t中不同字符数

        int ans = s.length();//r-l;
        String res = ""; //s.substring(l,r);
        for (; r<s.length();r++) {
            char ch = s.charAt(r);
//            if (!need.containsKey(ch)) {
//                continue;
//            }

//            if (cnt.getOrDefault(ch,0)==0) {
//                tot++;
//            }
            cnt.put(ch, cnt.getOrDefault(ch,0)+1);
            if (cnt.size()<k) {
                continue;
            }
            while (l<r) {
                ch = s.charAt(l);
                if (cnt.get(ch)<=1) {
                    if (cnt.size()==k) {
                        break;
                    }
                    cnt.remove(ch);
                } else {
                    cnt.put(ch, cnt.get(ch)-1);
                }
                l++;
            }
            if (r-l < ans) {
                ans = r-l;
                res = s.substring(l,r+1);
            }
        }
        if (tot<k) {
            return "";
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.lengthOfLongestSubstringKDistinct());
    }
}
