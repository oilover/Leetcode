package com.hl.sliding_window.k_distinct_longest;

import java.io.Serializable;
import java.util.*;

class Solution {
    static {
        System.out.println("stat block");
    }
    public int lengthOfLongestSubstringKDistinct(String s,int k) {
        int l=0,r=0;
        Map<Character,Integer> cnt = new HashMap<>();
        new ArrayList<>(5);
        int tot = 0; // 窗口内t中不同字符数
        int ans = 0;
        String res = ""; //s.substring(l,r);
        for (;r<s.length(); r++) {
            char ch = s.charAt(r);
            if (!cnt.containsKey(ch) && cnt.size()==k) {
                break;
            }
            cnt.put(ch, cnt.getOrDefault(ch,0)+1);
            while (cnt.size()>k) {
                ch = s.charAt(l);
                if (cnt.get(ch)==1) {
                    cnt.remove(ch);
                } else {
                    cnt.put(ch, cnt.get(ch)-1);
                }
                l++;
            }
            ans = Math.max(r-l+1,ans);
        }
        return ans;
    }
}
class A implements Serializable {
     static class B {private  class C {}}
    protected void f() {
//         new A.B.C();
        System.out.println("A pro..");
    }
}
class B extends A {

}
class C extends B {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("C final");
    }
}
public class Main {
    static void f(int a) {
        System.out.println("A");
    }
    static void f(Integer a) {
        System.out.println("BB");
    }
    static void gao() {
        try {
            System.exit(1);
            return;
        }catch (Exception e) {}
        finally {
            System.out.println("ha");
        }
    }
    public static void main(String[] args) {
//        new A.B();
        A a = new A();
//        A.B b = a.new B();
        {
            C c = new C();
            c.f();
        }
        Object o;
        Solution solution = new Solution();
//        solution.fin
        f(2);Integer i=8;i.toString();
        gao();
        System.out.println(solution.lengthOfLongestSubstringKDistinct("abc",  3));
        System.out.println(solution.lengthOfLongestSubstringKDistinct("eceba",  3));
        System.out.println(solution.lengthOfLongestSubstringKDistinct("eceba",  2));
        System.out.println(solution.lengthOfLongestSubstringKDistinct("aab",  1));
    }
}
