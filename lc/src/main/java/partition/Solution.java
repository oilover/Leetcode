package partition;

import java.util.Random;

public class Solution {
    void swap(int[] a, int i,int j) {
        int t=a[i];a[i]=a[j];a[j]=t;
    }
    Random rand = new Random(456);
    int partition(int[] a, int l, int r, int k) {
        if (l>=r) {
            return a[l];
        }
        int pivot = rand.nextInt(r-l+1)+l;
        swap(a, pivot, r);
        int x = a[r];
        int i = l-1;
        for (int j=l;j<=r;j++) {
            if (a[j]<=x) {
                swap(a, ++i, j);
            }
        }
        int p = l+k;
        if (i==l+k) return a[i];
        if (i<l+k) return partition(a, i+1, r, k-(i-l+1));
        return partition(a, l, i-1, k);
    }
    public int findKthLargest(int[] a, int k) {
        int n = a.length;
        k = n-k;
        return partition(a,0,n-1,k);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String a = "322", b="3";
        int a[] = {7,6,5,4,3,2,1};
        System.out.println(s.findKthLargest(a, 2));
    }
}
