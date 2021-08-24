package hl;

import java.util.*;

class Solution2 {
    private Graph<String> graph;
    List<List<String>> tickets;
    HashSet<String> visited;
    boolean dfs(String u, LinkedList<String> res) {
        res.add(u);
        if (res.size()==tickets.size()+1) {
            return true;
        }
        for (String v: graph.getNeighbors(u)) {
            String edge = u+" "+v;
            if (!visited.contains(edge)) {
                visited.add(edge);
//                res.add(v);
                if (dfs(v, res)) {
                    return true;
                }
                res.removeLast();
                visited.remove(edge);
            }
        }
        return false;
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        this.tickets = tickets;
        graph = new Graph<>();
        LinkedList<String> res = new LinkedList<>();
        for (List<String> ticket:tickets) {
            graph.addEdge(ticket.get(0), ticket.get(1));
        }
        HashMap<String, Integer> cnt = new HashMap<>();
        for (String loc: graph.getNodes()) {
            cnt.put(loc, 0);
        }
        String cur = "JFK";
        visited = new HashSet<>();
        dfs(cur, res);
//        while (true) {
//            res.add(cur);
//            String next = graph.removeMin(cur);
//            if (next==null) {
//                break;
//            }
//            cur = next;
//        }
        return res;
    }
}
public class Reconstruct {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        List<List<String>> list = Arrays.asList(Arrays.asList("MUC","LHR"),Arrays.asList("JFK","MUC"),
                Arrays.asList("SFO","SJC"),Arrays.asList("LHR","SFO"));
//        list.
        list = Arrays.asList(Arrays.asList("JFK","KUL"),Arrays.asList("JFK","NRT"),Arrays.asList("NRT","JFK"));
        System.out.println(s.findItinerary(list));
    }
}
