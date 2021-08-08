package com.hl.stack;

import java.util.*;
/**
 * 一个数轴，一些球有质量并以1m/s速度向左或右移动
 * 负质量代表向左，正代表向右
  */

public class Main {
    List<Integer> asteroidCollision(int[] a) {
        int n = a.length;
//        int[] dead = new int[n];
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
            while (!stack.isEmpty() && a[stack.peek()]>0 && Math.abs(a[stack.peek()]) < -x) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (a[stack.peek()] == -x) {
                    stack.pop();
                }
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
//        int[] ts = new int[res.size()];
//        for (int i=0;i<res.size();i++) {
//            ts[i] = res.get(i);
//        }
//        return ts;
    }

    public static void main(String[] args) {
        Main s = new Main();
        System.out.println(s.asteroidCollision(new int[]{5,-6}));
        System.out.println(s.asteroidCollision(new int[]{-6,7}));
        System.out.println(s.asteroidCollision(new int[]{6,-6}));
        System.out.println(s.asteroidCollision(new int[]{-6,7,-2,-100}));

    }
}
