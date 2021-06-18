package word;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean isRobotBounded(String instructions) {
        int dir = 0;
        int x=0, y=0;
        for (char ch: instructions.toCharArray()) {
            if (ch=='L') {
                dir = (dir+1)%4;
                continue;
            }
            if (ch=='R') {
                dir = (dir+3)%4;
                continue;
            }
            switch (dir) {
                case 0: y++; break;
                case 1: x--; break;
                case 2: y--; break;
                default: x++; break;
            }
        }
        return (x==0&&y==0) || dir!=0;
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += " ";
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
            if (t>=cnt.getOrDefault(ans,0)) {
                ans = w;
            }
            cnt.put(w, t);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
//        String[] arr = new String[];
        System.out.println(s.isRobotBounded("GGLLGG"));
        System.out.println(s.mostCommonWord("Bob", new String[]{}));
    }
}