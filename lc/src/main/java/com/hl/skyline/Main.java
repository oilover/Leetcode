package com.hl.skyline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Endpoint implements Comparable<Endpoint> {
    private int x, height;
    boolean left;

    public Endpoint(int x, int height, boolean left) {
        this.x = x;
        this.height = height;
        this.left = left;
    }

    @Override
    public int compareTo(Endpoint o) {
        return x - o.x;
    }
}
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<Endpoint> endpoints = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int[] building: buildings) {
            endpoints.add(new Endpoint(building[0], building[2], true));
            endpoints.add(new Endpoint(building[1], building[2], false));
        }
        Collections.sort(endpoints);
        return  res;
    }
}
public class Main {

}
