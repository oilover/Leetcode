package lb;

import java.util.HashMap;

public class LRUCache {
    private DoublyList list;
    private HashMap<Integer, Node> map;
    private int capacity;
//    DoubleList
    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new DoublyList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node res = map.get(key);
        put(key, res.val);
        return res.val;
    }

    public void put(int key, int value) {
        Node p;
        if (map.containsKey(key)) {
            p = map.get(key);
            list.remove(p);
        } else {
            if (map.size() == capacity) {
                p = list.removeLast();
                map.remove(p.key);
            }
        }
        p = new Node(key, value);
        list.insertHead(p);
        map.put(key, p);
    }
}
