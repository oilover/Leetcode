package amazon.reorder;

import java.util.Arrays;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2)->{
            String[] a = log1.split(" ", 2);
            String[] b = log2.split(" ", 2);
            boolean isDight1 = Character.isDigit(a[1].charAt(0));
            boolean isDight2 = Character.isDigit(b[1].charAt(0));
            if (!isDight1 && !isDight2) {
                if (!a[1].equals(b[1])) {
                    return a[1].compareTo(b[1]);
                }
                return a[0].compareTo(b[0]);
            }
            if (isDight1 && isDight2) {
                return 0;
            }
            return isDight1 ? -1 : 1;
//            if (Character.isLetter(a[1].charAt(0)) && Character.isDigit(b[1].charAt(0))) {
//                return -1;
//            }
//            if (Character.isDigit(a[1].charAt(0)) && Character.isLetter(b[1].charAt(0))) {
//                return 1;
//            }
        });
        return logs;
    }
}
public class Main {
    public static void main(String[] args) {
        String[] logs = new String[]{"let1 art can","let3 art zero",
                "let2 own kit dig","dig1 8 1 5 1","dig2 3 6"};
        Solution s = new Solution();
        s.reorderLogFiles(logs);
    }
}
