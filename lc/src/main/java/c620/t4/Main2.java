package c620.t4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    final int BLOCK_SIZE = 300;
    int n, blockNum;
    int[] sorted, minDiff;
    int f(int i) {
        return i/BLOCK_SIZE;
    }
    int bMax(int block) {
        return sorted[Math.min((block+1)*BLOCK_SIZE, n)-1];
    }
    int bMin(int i) {
        return sorted[i*BLOCK_SIZE];
    }
    public int[] minDifference(int[] nums, int[][] queries) {
        n = nums.length;
        blockNum = (n+BLOCK_SIZE-1)/BLOCK_SIZE;
        sorted = new int[n];
        minDiff = new int[blockNum+1];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[i];
        }
        for (int i = 0; i < blockNum; i++) {
            minDiff[i] = Integer.MAX_VALUE;
            Arrays.sort(sorted, i*(BLOCK_SIZE), Math.min((i+1)*(BLOCK_SIZE),n));
        }
        for (int i = 0; i < n-1; i++) {
            if (i%BLOCK_SIZE < BLOCK_SIZE-1) {
                int block = i/BLOCK_SIZE;
                minDiff[block] = Math.min(minDiff[block], sorted[i+1]-sorted[i]);
            }
        }
        int res[] = new int[queries.length];
        int qid = 0;
        for (int[] q: queries) {
            int l = q[0], r = q[1];
            int startBlock = f(l), endBlock = f(r);
            int ans = Integer.MAX_VALUE;
            for (int i = startBlock; i < endBlock; i++) {
                ans = Math.min(ans, bMin(i+1)-bMax(i));
            }
            for (int i = startBlock+1; i < endBlock; i++) {
                ans = Math.min(ans, minDiff[i]);
            }
            List<Integer> list = new ArrayList<>();
            for (int i = l; i < (startBlock+1)*BLOCK_SIZE; i++) {
                list.add(nums[i]);
            }
            res[qid++] = ans;
        }
        return res;
    }
}
public class Main2 {
}
