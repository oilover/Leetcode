package com.company.sad;

class Solution {
    int f(String s) {
        int a = 0;
        for (char ch: s.toCharArray()) {
            a=a*10+ch-'a';
        }
        return a;
    }
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return f(firstWord) + f(secondWord) == f(targetWord);

    }
}
public class Main {
}
