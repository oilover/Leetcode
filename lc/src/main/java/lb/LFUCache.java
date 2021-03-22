package lb;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LFUCache {
    private HashMap<Integer, DoublyList> lists;
    private HashMap<Integer, Node> map;
    private int capacity;
    public LFUCache(int capacity) {
        map = new HashMap<>();
        lists = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node p = map.get(key);
        int cnt = p.cnt;
        lists.get(cnt).remove(p);
        p.addCnt();
        cnt++;
        if (!lists.containsKey(cnt)) {
            lists.put(cnt, new DoublyList());
        }
        lists.get(cnt).insertHead(p);
        return p.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node p = map.get(key);
            int cnt = p.cnt;
            lists.get(cnt).remove(p);
            p.addCnt();
            cnt++;
            if (!lists.containsKey(cnt)) {
                lists.put(cnt, new DoublyList());
            }
            lists.get(cnt).insertHead(p);
        } else {
            if (map.size()==capacity) {
                ;
            }
        }
        Node p;
    }

    public static void main(String[] args) {
        TreeMap<String,String> treeMap = new TreeMap<>();
        treeMap.put("b", "3");
        treeMap.put("a", "33");
        for (Map.Entry<String,String> x: treeMap.entrySet()
             ) {
            System.out.println(x.getKey()+ x.getValue());
        }
    }
}
