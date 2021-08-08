package hl.valid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int ord(char c) {
        switch (c) {
            case ' ':
                return 0;
            case '+':
            case '-':
                return 1;
            case '.':
                return 3;
            case 'e':
                return 4;
            default:
                if (Character.isDigit(c)) {
                    return 2;
                }
        }
        return -1;
    }

    public boolean isNumber(String s) {
        return false;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length, wordLen = words[0].length();
        HashMap<String, Integer> hm = new HashMap<>();
        for (String word: words) {
            hm.put(word, hm.getOrDefault(word, 0)+1);
        }
        List<Integer> res = new ArrayList<>();
        for (int start = 0; start <= s.length()-wordLen*n; start++) {
            int t = start;
            HashMap<String, Integer> cnt = (HashMap<String, Integer>) hm.clone();
            boolean ok = true;
            for (int i = 0; i < words.length; i++,t+=wordLen) {
                String str = s.substring(t, t+wordLen);
                if (cnt.containsKey(str) && cnt.get(str)>0) {
                    cnt.put(str, cnt.get(str)-1);
                } else {
                    ok = false; break;
                }
            }
            if (ok) {
                res.add(start);
            }
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        System.out.println(s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        System.out.println(s.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }
}
