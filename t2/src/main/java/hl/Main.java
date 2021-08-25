package hl;

import java.util.*;


class Solution3 {
    private Graph<Integer> graph;
    void dfs(int u, int cur, boolean[] visited, List<Integer> block) {
        if (visited[u]) {
            return;
        }
        visited[u] = true;
        block.set(u, cur);
        for (int v: graph.getNeighbors(u)) {
            dfs(v, cur, visited, block);
        }
    }
    List<Integer> group;
    int[] parent;
    int getGroup(int u) {
        if (parent[u] == u) {
            return u;
        }
        parent[u] = getGroup(parent[u]);
        return parent[u];
    }
    void union(int u, int v) {
        int fu = getGroup(u), fv = getGroup(v);
        parent[fu] = fv;
    }
    int[] solve(int n, int[][] dependencies) {
        graph = new Graph<>();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge: dependencies) {
            int u = edge[0], v = edge[1];
            graph.addEdge(u, v);
            union(u,v);
        }
        return parent;
//        boolean[] visited = new boolean[n];
//        group = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            group.add(i);
//        }
//        int cur = 0;
//        for (int i = 0; i < n; i++) {
//            if (visited[i]) {
//                continue;
//            }
//            cur++;
//            dfs(i, cur, visited, group);
//        }
//        return group;
    }
//    List<Integer> addEdge(int u, int v) {
//
//    }
}
public class Main {
    public static void main(String[] args) {
        Integer i = new Integer(898);
        System.out.println(i.hashCode());
        i = 123;
        System.out.println(i.hashCode());
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        Solution3 solution = new Solution3();
        int[][] dependencies = new int[][]{{1,3},{2,3},{4,0}};
        System.out.println(Arrays.toString(solution.solve(5, dependencies)));
    }
}
