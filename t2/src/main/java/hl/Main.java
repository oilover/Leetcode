package hl;

import java.util.*;

class Graph {
    private final Map<Integer,List<Integer>> neighbors;
    Graph(int n) {
        neighbors = new HashMap<>();
        for (int i = 0; i < n; i++) {
            neighbors.put(i, new ArrayList<>() );
        }
    }
    void addEdge(int u, int v) {
        neighbors.get(u).add(v);
        neighbors.get(v).add(u);
    }
    void addNode(int u) {
        neighbors.put(u, new ArrayList<>());
    }
    void removeNode(int u) {
        neighbors.remove(u);
    }
    void removeEdge(int u, int v) {
//        neighbors.get(u).r
    }
    List<Integer> getNeighbors(int u) {
        return neighbors.get(u);
    }
}
class Solution {
    private Graph graph;
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
        graph = new Graph(n);
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
        Solution solution = new Solution();
        int[][] dependencies = new int[][]{{1,3},{2,3},{4,0}};
        System.out.println(Arrays.toString(solution.solve(5, dependencies)));
    }
}
