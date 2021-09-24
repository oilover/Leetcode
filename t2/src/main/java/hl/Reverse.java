package hl;

import java.util.ArrayList;
import java.util.List;

public class Reverse {
    String reverse(String s) {
        if (s==null||s.isEmpty()) {
            return "";
        }
        String[] words = s.split(" ");
        List<String> res = new ArrayList<>();
        for (String word: words) {
            char chs[] = word.toCharArray();
            int i = 0;
            int n = chs.length;
            for (;i<chs.length;) {
                int j=i;
                while (j<n && Character.isAlphabetic(chs[j])) j++;
                j--;
                int end = j;
                for (; i<j; i++,j--) {
                    char t = chs[i];
                    chs[i] = chs[j];
                    chs[j] = t;
                }
                i = end+1;
                while (i<n && !Character.isAlphabetic(chs[i])) i++;
            }
            res.add(new String(chs));
        }
        if (res.isEmpty()) return "";
        String ans = res.get(0);
        for (int i=1;i<res.size();i++) {
            ans += " " + res.get(i);
        }
        return ans;
    }
    String reverse2(String s) {
        if (s==null||s.isEmpty()) {
            return "";
        }
        char[] chs = s.toCharArray();
        int wordStart = 0, wordEnd=0;
        for (; wordEnd<s.length();) {
            wordEnd = wordStart;
            while (wordEnd<s.length()&&chs[wordEnd]!=' ') wordEnd++;
            int i = wordStart;
            for (;i<wordEnd;) {
                int j=i;
                while (j<wordEnd && Character.isAlphabetic(chs[j])) j++;
                j--;
                int end = j;
                for (; i<j; i++,j--) {
                    char t = chs[i];
                    chs[i] = chs[j];
                    chs[j] = t;
                }
                i = end+1;
                while (i<wordEnd && !Character.isAlphabetic(chs[i])) i++;
            }
            wordStart=wordEnd;
            while (wordStart<s.length() && chs[wordStart]==' ') wordStart++;
        }
        return new String(chs);
    }
    public static void main(String[] args) {
        Reverse r = new Reverse();
        System.out.println(r.reverse2("Hello, my name is Jack!"));
        System.out.println(r.reverse2("He's, my name is Jack!"));
        System.out.println(r.reverse2("He'sJack!"));
        System.out.println(r.reverse2("He'sJack!abc"));
        System.out.println(r.reverse2("He"));
        System.out.println(r.reverse2("';,'"));
        System.out.println(r.reverse2("Hello,world"));
        System.out.println(r.reverse2("Hello   world"));
    }
}
