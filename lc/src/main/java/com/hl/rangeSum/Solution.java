package com.hl.rangeSum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class NumArray {
    int a[] = new int[4];
    int block[];
    final int blockSize = 200;
    public NumArray(int[] nums) {
        a = nums;
        int n = a.length;
        int blocks = (int)Math.ceil(1.0*n/blockSize); //Math.sqrt((int)n+0.5);
        block = new int[blocks];
        for (int i=0;i<n;i++) {
            block[i/blockSize] += a[i];
        }
    }

    public void update(int index, int val) {
        int delta = val-a[index];
        a[index] = val;
        block[index/blockSize] += delta;
    }

    public int sumRange(int left, int right) {
        int l = left/blockSize, r=right/blockSize;
        int res = 0;
        for (int i=l+1;i<r;i++) {
            res += block[i];
        }
        for (int i=left;i<=right&&i<(l+1)*blockSize;i++) res+=a[i];
        if (l<r) for (int i=r*blockSize;i<=right;i++) res+=a[i];
        return res;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(1.0*8/2);
        Deque<Integer> deque = new LinkedList<Integer>();
//        deque.peekLast();deque.getLast()
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0,2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0,2));
    }
}
