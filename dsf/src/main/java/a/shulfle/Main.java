package a.shulfle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    // 对B中从小到大每一个数，尝试用A中尽可能小的数打败他
    public int[] advantageCount(int[] a, int[] b) {
        int n = a.length;
        Integer[] aId = new Integer[n];
        Integer[] bId = new Integer[n];
        for (int i = 0; i < n; i++) {
            aId[i] = bId[i] = i;
        }
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> a[x]));
//        for (int i = 0; i < n; i++) {
//            pq.offer(i);
//        }
        Arrays.sort(aId, Comparator.comparingInt(x -> a[x]));
        Arrays.sort(bId, Comparator.comparingInt(x -> b[x]));
//        System.out.println(Arrays.toString(bId));
        int i = 0, j = 0;
        int[] ans = new int[n];
        boolean[] used = new boolean[n];
        for (i = 0; i < n; i++, j++) {
            while (j < n && a[aId[j]] <= b[bId[i]]) {
                j++;
            }
            if (j >= n) break;
            used[j] = true;
            // bId[i] 和 aId[j] 配对
            ans[bId[i]] = a[aId[j]];
        }
        for (j = 0; i < n; i++, j++) {
            while (j < n && used[j]) j++;
            ans[bId[i]] = a[aId[j]];
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.advantageCount(new int[]{8,12, 24, 32}, new int[]{13, 25, 32, 11})));
        System.out.println(Arrays.toString(s.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
        System.out.println(Arrays.toString(s.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
    }
}
