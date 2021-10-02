package hl.t3.t2;

import java.util.Random;

/**
 * 三门问题
 */
class Solution {
    Random rnd = new Random();

    void solve(int tries) {
        int oldGate = 0, newGate = 0;
        for (int i = 0; i < tries; i++) {
            int ball = rnd.nextInt(3); // 有车的门
            int select = rnd.nextInt(3); // 选的门
            int open = 0;
            for (int j = 0; j < 3; j++) { // 找一扇没有选且没有车的门打开
                if (select != j && ball != j) {
                    open = j;
                    break;
                }
            }
            int notOpen = 0;
            for (int j = 0; j < 3; j++) { // 换的门，就是没有选且没有打开的门
                if (select != j && open != j) {
                    notOpen = j;
                    break;
                }
            }
            if (select == ball) {
                oldGate++;
            }
            if (notOpen == ball) newGate++;
        }
        System.out.printf("%.4f %.4f\n", 1.0 * oldGate / tries, 1.0 * newGate / tries);
    }
}

public class Main2 {
    public static void main(String[] args) {
//        Map<S>
        Solution s = new Solution();
        s.solve(10000);
    }
}
