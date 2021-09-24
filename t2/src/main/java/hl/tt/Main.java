package hl.tt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution1 {
    List<List<Integer>> findTriples(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            if (i > 0 && a[i] == a[i - 1]) {
                continue;
            }
            while (j < k) {
                while (j < k && a[j] == a[j - 1] && a[j] != a[i]) j++;
                while (j < k && k < n - 1 && a[k] == a[k + 1] && a[k] != a[j]) k--;
                if (j >= k) {
                    break;
                }
                int sum = a[i] + a[j] + a[k];
                if (sum == 0) {
                    res.add(Arrays.asList(a[i], a[j], a[k]));
                    j++;
                }
                if (sum < 0) {
                    j++;
                }
                if (sum > 0) {
                    k--;
                }
            }
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(s.findTriples(new int[]{0, 0, 0}));
        System.out.println(s.findTriples(new int[]{0, 0}));
        System.out.println(s.findTriples(new int[]{1, -1}));
        System.out.println(s.findTriples(new int[]{-1, -1, 2}));
        System.out.println(s.findTriples(new int[]{-2, 1, 1, 2,0}));
        System.out.println(s.findTriples(new int[]{}));
        System.out.println(s.findTriples(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(s.findTriples(new int[]{-1, 0, 1, 2, -1, -4, -2, 4, -2}));
    }
}
