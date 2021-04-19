package com.hl.log;

import java.util.*;

class Request implements Comparable<Request>{
    int id;
    int start, end;
    public Request(int id, int s, int e) {
        this.id = id;
        start = s;
        end = e;
    }

    @Override
    public int compareTo(Request o) {
        return start-o.start;
    }
}
class Solution {
    PriorityQueue<Request> pq;
    Map<Integer, Integer> start, end;
    List<Request> res;
    public Solution() {
        start = new HashMap<>();
        end = new HashMap<>();
        res = new ArrayList<>();
        pq = new PriorityQueue<>();
    }
    public void log(int id, int time) {
        if (!start.containsKey(id)) {
            start.put(id,time);
            pq.add(new Request(id, time, 0));
            return;
        }
        end.put(id, time);
        // 如果开始时间最小的数据已经结束，加入答案
        while (!pq.isEmpty() && end.containsKey(pq.peek().id)) {
            Request r = pq.poll();
            r.end = end.get(r.id);
            System.out.println(r.id+","+r.start+","+r.end);
            res.add(r);
        }
    }
    public void print() {
        for (Request r: res) {
            System.out.println(r.id+","+r.start+","+r.end);
        }
        System.out.println();
    }
}
public class Main {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        Solution s = new Solution();
        s.log(1,0);
        s.log(2,1);
        s.log(3,2);
        s.log(3,9);
        s.log(2,10);
        s.log(1,14);
//        s.print();
        s.log(11,20);
        s.log(12,21);
        s.log(13,22);
        s.log(11,110);
        s.log(13,115);
        s.log(12,120);
//        s.print();
        System.out.println("Hello World!");
    }
}
