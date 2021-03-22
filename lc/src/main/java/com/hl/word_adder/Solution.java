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
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, String> prevWord = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.equals(endWord)) {
                break;
            }
            for (String word: wordList) if (!prevWord.containsKey(word) && canChange(cur, word)) {
                queue.offer(word);
                prevWord.put(word, cur);
            }
        }
        List<List<String>> res = new ArrayList<>();
        if (!prevWord.containsKey(endWord)) {
            return res;
        }
//        Collections.
    }
}
