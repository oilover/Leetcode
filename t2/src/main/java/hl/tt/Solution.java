package hl.tt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

interface It {}
abstract class Ab {
    final int f() {
        return 3;
    }
}
public class Solution {
    // 返回去重后元素个数，发现没有和已经扫描过的重复，在newLen处插入
    int removeDup(int[] a) {
//        HashSet<Integer> set = new HashSet<>();
        int newLen = 0; // [
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            boolean contain = false;
            for (int j = 0; j < newLen; j++) {
                if (a[j] == a[i]) {
                    contain = true;
                    break;
                }
            }
            if (!contain) {
                a[newLen++] = a[i];
            }
        }
        return newLen;
    }

    String testDup(int[] a) {
        int n = removeDup(a);
        return (n + " " + Arrays.toString(a));
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        Integer a[] = new Integer[]{0, 1, 2};
        Integer b[] = new Integer[]{3, 1, 2};
        System.out.println(Arrays.toString(a));
//        System.out.println(s.removeDup(new int[]{}));
//        Arrays.sort(a, (x, y) -> b[x] - b[y]);
//        System.out.println(Arrays.toString(a));
//        System.out.println("sdfE".toLowerCase());
//        System.out.println(s.testDup(new int[]{1, 2, 3}));
//        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
//        System.out.println(s.testDup(new int[]{2, 2, 2}));
//        System.out.println(s.testDup(new int[]{2, 3, 2, 3}));
//        System.out.println(s.testDup(new int[]{3, 2, 2, 2, 3}));
    }
}
