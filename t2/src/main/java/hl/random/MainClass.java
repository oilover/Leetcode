package hl.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        neighbors.get(u).add(v);
//        neighbors.get(v).add(u);
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
        return res;
    }
}

public class MainClass {
//    public static String[] stringToStringArray(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(line);
//        String[] arr = new String[jsonArray.size()];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = jsonArray.get(i).asString();
//        }
//        return arr;
//    }
//
//    public static List<List<String>> stringToString2dArray(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        if (jsonArray.size() == 0) {
//            return new ArrayList<List<String>>();
//        }
//        List<List<String>> list = new ArrayList<>(jsonArray.size());
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JsonArray cols = jsonArray.get(i).asArray();
//            list.add(stringToStringList(cols.toString()));
//        }
//        return list;
//    }
//
//    public static List<List<String>> stringToString2dArray(String input) {
//        JsonArray jsonArray = JsonArray.readFrom(input);
//        if (jsonArray.size() == 0) {
//            return new ArrayList<List<String>>();
//        }
//        List<List<String>> list = new ArrayList<>(jsonArray.size());
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JsonArray cols = jsonArray.get(i).asArray();
//            list.add(stringToStringList(cols.toString()));
//        }
//        return list;
//    }
//    public static String stringListToString(List<String> stringList) {
//        StringBuilder sb = new StringBuilder("[");
//        for (String item : stringList) {
//            sb.append(item);
//            sb.append(",");
//        }
//
//        sb.setCharAt(sb.length() - 1, ']');
//        return sb.toString();
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            List<List<String>> tickets = stringToString2dList(line);
//
//            List<String> ret = new Solution().findItinerary(tickets);
//
//            String out = stringListToString(ret);
//
//            System.out.print(out);
//        }
//    }
}