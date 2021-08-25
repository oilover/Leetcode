package hl;

import java.util.*;

class Graph<T extends Comparable<T>> {
    private final Map<T, TreeSet<T>> neighbors;
    Graph() {
        neighbors = new HashMap<>();
    }
    Set<T> getNodes() {
        return neighbors.keySet();
    }
    boolean exist(T u) {
        return neighbors.containsKey(u);
    }
    void addEdge(T u, T v) {
        addNode(u); addNode(v);
        TreeSet<T> ts = neighbors.get(u);
//        if (ts.contains(v)) {
//            System.out.println("sdf");
//        }
        ts.add(v);
    }
    void addNode(T u) {
        if (!exist(u)) {
            neighbors.put(u, new TreeSet<>());
        }
    }
    void removeNode(T u) {
        neighbors.remove(u);
    }
    TreeSet<T> getNeighbors(T u) {
        return neighbors.get(u);
    }
    T removeMin(T u) {
        return neighbors.get(u).pollFirst();
    }
}
class Solution {
    private Graph<String> graph;
    List<List<String>> tickets;
    HashMap<String,Integer> visited;
    List<String> ans;
    boolean dfs(String u, int i, LinkedList<String> res) {
        res.add(u);
        if (++i==tickets.size()+1) {
            ans = new LinkedList<>(res);
            return true;
        }
        for (String v: graph.getNeighbors(u)) {
            String edge = u+" "+v;
            if (visited.getOrDefault(edge,0)>0) {
                visited.put(edge,visited.get(edge)-1);
                if (dfs(v, i, res)) {
//                    res.addFirst(v);
                    return true;
                }
                res.removeLast();
                visited.put(edge,visited.get(edge)+1);
//                visited.remove(edge);
            }
        }
        return false;
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        this.tickets = tickets;
        graph = new Graph<>();
        LinkedList<String> res = new LinkedList<>();
        visited = new HashMap<>();
        for (List<String> ticket:tickets) {
            String e0 = ticket.get(0), e1 = ticket.get(1);
            graph.addEdge(ticket.get(0), ticket.get(1));
            String edge = e0+" "+e1;
            visited.put(edge, visited.getOrDefault(edge,0)+1);
        }
        HashMap<String, Integer> cnt = new HashMap<>();
        for (String loc: graph.getNodes()) {
            cnt.put(loc, 0);
        }
        String cur = "JFK";
        ans = new LinkedList<>();
        dfs(cur, 0, res);
        return ans;
    }
}
public class Reconstruct {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> list = Arrays.asList(Arrays.asList("MUC","LHR"),Arrays.asList("JFK","MUC"),
                Arrays.asList("SFO","SJC"),Arrays.asList("LHR","SFO"));
//        list.
        list = Arrays.asList(Arrays.asList("JFK","KUL"),Arrays.asList("JFK","NRT"),Arrays.asList("NRT","JFK"));
        System.out.println(s.findItinerary(list));
        list = Arrays.asList(Arrays.asList("JFK","A"),Arrays.asList("JFK","B"),Arrays.asList("B","JFK"));
        System.out.println(s.findItinerary(list));

    }
}
