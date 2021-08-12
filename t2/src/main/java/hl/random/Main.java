package hl.random;

import java.util.*;

class RandomizedSet {
    private final Random random;
    List<Integer> list;
    Map<Integer, Integer> position;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        random = new Random();
        list = new ArrayList<>();
        position = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (position.containsKey(val)) {
            return false;
        }
        int size = position.size();
        if (size==list.size()) {
            list.add(val);
        } else {
            list.set(size, val);
        }
        position.put(val, size);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!position.containsKey(val)) {
            return false;
        }
        int pos = position.get(val);
        int t = list.get(position.size()-1);
        list.set(pos, t);
        position.put(t, pos);
        position.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int i = random.nextInt(position.size());
        return list.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
public class Main {
}
