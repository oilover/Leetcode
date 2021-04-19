package com.hl.word_adder;

import java.util.*;

public class Solution {
    boolean canChange(String source, String target) {
        char []a = source.toCharArray();
        char []b = target.toCharArray();
        if (a.length != b.length) {
            return false;
        }
        int cnt = 0;
        for (int i=0;i<a.length;i++) if (a[i]!=b[i]) {
            if (cnt==1) {
                return false;
            }
            cnt++;
        }
        return true;
    }
    void dfs(String target, String cur, LinkedList<String> path, List<List<String>> res) {
        if (cur.equals(target)) {
            List<String> t = new ArrayList<>();
            Collections.copy(path, t);
            Collections.reverse(t);
            res.add(t);
            return;
        }
        Set<String> list = prevWord.get(cur);
        for (String word: list) {
            if (visited.contains(word)) {
                continue;
            }
            visited.add(word);
            path.add(word);
            dfs(target, word, path, res);
            visited.remove(word);
            path.removeLast();
        }
    }
    HashMap<String, Set<String>> prevWord = new HashMap<>();
    HashSet<String> visited = new HashSet<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        prevWord = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.equals(endWord)) {
                break;
            }
            for (String word: wordList) if (canChange(cur, word)) {
                queue.offer(word);
                if (!prevWord.containsKey(word)) {
                    prevWord.put(word, new HashSet<>());
                }
                prevWord.get(word).add(cur);
            }
        }
        List<List<String>> res = new ArrayList<>();
        if (!prevWord.containsKey(endWord)) {
            return res;
        }
        LinkedList<String> path = new LinkedList<>();
        visited = new HashSet<>();
        dfs(beginWord, endWord, path, res);
        return res;
//        Collections.
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String arr[] = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> l = Arrays.asList(arr);
        System.out.println(s.findLadders("hit", "cog", l));
    }
}
