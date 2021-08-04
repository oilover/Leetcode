package com.hl.network_delay;

import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->dist[x]-dist[y]);
        return 0;
    }
    private int getMask(String s) {
        int res = 0;
        for (char ch: s.toCharArray()) {
            int t = 1<<(ch-'a');
            if ((res&t)==0) {
                res |= t;
            } else {
                return -1;
            }
        }
        return res;
    }
    int res = 0;
    void dfs(int i, int mask, List<Integer> list) {
        if (i==list.size()) {
            res = Math.max(res, Integer.bitCount(mask));
            return ;
        }
        dfs(i+1, mask, list);
        int cur = list.get(i);
        if (cur!=-1 && (mask&cur)==0) {
            dfs(i+1, mask|cur, list);
        }
    }
    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        for (String s: arr) {
            list.add(getMask(s));
        }
        res = 0;
        dfs(0,0,list);
        return res;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] dist = new int[]{2,1,3};
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->dist[x]-dist[y]);
        pq.add(0);
        pq.add(1);
        pq.add(2);
        for (int i = 0; i < 3; i++) {
            System.out.println(pq.poll());
        }
        LinkedList<Integer> l = new LinkedList<>();
        Solution s = new Solution();
        System.out.println(s.maxLength(Arrays.asList("un","iq","ue")));
        System.out.println(s.maxLength(Arrays.asList("cha","r","act","ers")));
        System.out.println(s.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
        System.out.println(s.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
    }
}
