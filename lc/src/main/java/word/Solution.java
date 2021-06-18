package word;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean isRobotBounded(String instructions) {
        return false;
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        StringBuilder word = new StringBuilder();
        HashSet<String> hs = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> cnt = new HashMap<>();
        String ans = "";
        for (char ch: paragraph.toCharArray()) {
            if (Character.isLetter(ch)) {
                word.append(Character.toLowerCase(ch));
                continue;
            }
            if (word.length()==0) {
                continue;
            }
            String w = new String(word);
            word = new StringBuilder();
            if (hs.contains(w)) { // banned
                continue;
            }
            int t = cnt.getOrDefault(w,0)+1;
            if (t>cnt.getOrDefault(ans,0)) {
                ans = w;
            }
            cnt.put(w, t);
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}