package hl.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Solution {
    private int m,n;
    private PriorityQueue<int[]> pq;
    private HashSet<Integer> hs;
    void getNxt(int[] a, int[] b, int i, int j) {
        if (i==m) {
            j++;
            i=0;
        }
        if (j==n) {
            i++;
            j=0;
        }
        if (i<m&&j<n) {
            int t = i*n+j;
            if (!hs.contains(t)) {
                hs.add(t);
                pq.add(new int[]{a[i]+b[j],i,j});
            }
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        pq = new PriorityQueue<>((x,y)->x[0]-y[0]);
        hs = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        m = a.length; n = b.length;
        if (m==0||n==0) {
            return res;
        }
        pq.add(new int[]{a[0]+b[0],0,0});
        int i=0,j=0;
        hs.add(0);
        while (res.size()<k&&!pq.isEmpty()) {
            int[] cur = pq.poll();
            i = cur[1]; j = cur[2];
            res.add(Arrays.asList(a[i],b[j]));
            if (i==m-1&&j==n-1) {
                break;
            }
            getNxt(a,b,i+1,j);
            getNxt(a,b,i,j+1);
        }
        return res;
    }
}
public class MainClass {
    public static void main(String[] args) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->x[0]-y[0]);
        pq.add(new int[]{2,3});
        pq.add(new int[]{1,3});
        String st = "cdbcaad";
        System.out.println(Arrays.toString(st.split("[ab]+")));
        Solution s = new Solution();
        System.out.println(s.kSmallestPairs(new int[]{1,1,2}, new int[]{1,1,3}, 10));
        System.out.println(s.kSmallestPairs(new int[]{1,2}, new int[]{3}, 3));
        System.out.println(s.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 4));
//        System.out.println(s.kSmallestPairs(new int[]{1}, new int[]{2}, 1));
//        System.out.println(s.kSmallestPairs(new int[]{1,2}, new int[]{-3,9}, 4));
    }
}