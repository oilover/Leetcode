package com.hl.stack;

import java.util.*;

public class Main {
    List<Integer> solve(int[] a) {
        int n = a.length;
        int[] dead = new int[n];
        Stack<Integer> stack = new Stack<>();
//        for (int x: a) {
//            res.add(x);
//        }
//        Iterator<Integer> it = res.iterator();
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<n;i++) {
            int x = a[i];
            if (x>0) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && Math.abs(a[stack.peek()]) <= -x) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res.add(i);
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        Collections.sort(res);
        for (int i=0;i<res.size();i++) {
            res.set(i, a[res.get(i)]);
        }
        return res;
    }

    public static void main(String[] args) {
        Main s = new Main();
        System.out.println(s.solve(new int[]{5,-6}));
        System.out.println(s.solve(new int[]{-6,7}));
        System.out.println(s.solve(new int[]{-6,6}));
        System.out.println(s.solve(new int[]{-6,7,-2,-100}));

    }
}
