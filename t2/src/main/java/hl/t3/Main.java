package hl.t3;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

class Solution {
    byte[] encode(int n) {
        byte[] res = new byte[4];
        for (int i = 0; i < 4; i++) {
            res[3 - i] = (byte) (n & 255);
            n >>>= 8;
        }
        return res;
    }

    int decode(byte[] a) {
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res = (res << 8) + a[i];
        }
        return res;
    }
}

/**
 * @author hl
 */
public class Main {
    static int steps(int n) {
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }


    public static void main(String[] args) {
        for (int n = 1; n < 12; n++) {
//            String.join()
//            System.out.println(n + " " + steps(n));
        }
        Solution s = new Solution();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int x = r.nextInt((int) 1e8);
            System.out.println(x + " " + s.decode(s.encode(x)));
        }
//        System.out.println(ste);
    }
}
