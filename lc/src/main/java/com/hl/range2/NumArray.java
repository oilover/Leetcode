package com.hl.range2;

//public class  {
//}
class Tree {
    int tree[];
    int lowbit(int x) {
        return x&-x;
    }
    int n;
    public Tree(int n) {
        this.n = n;
        tree = new int[n+1];
    }
    void add(int x, int v) {
        for (; x<=n; x+=lowbit(x)) {
            tree[x] += v;
        }
    }
    public int sum(int x) {
        int res = 0;
        for (; x>0; x-=lowbit(x)) {
            res += tree[x];
        }
        return res;
    }
}
public class NumArray {
    int a[] = new int[4];
    int block[];
    final int blockSize = 200;
    Tree tree;

    public NumArray(int[] nums) {
        a = nums;
        int n = a.length;
        tree = new Tree(n);
        for (int i=0;i<n;i++) {
            tree.add(i+1, nums[i]);
        }
    }

    public void update(int index, int val) {
        int delta = val-a[index];
        a[index] = val;
        tree.add(index+1, delta);
//        block[index/blockSize] += delta;
    }

    public int sumRange(int left, int right) {
        return tree.sum(right+1)-tree.sum(left);
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0,2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0,2));
    }
}