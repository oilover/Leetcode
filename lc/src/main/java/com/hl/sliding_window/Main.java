package com.hl.sliding_window;

import java.lang.instrument.Instrumentation;

enum A {
    ea, eb;
}
public class Main {
    public static void main(String[] args) {
        A t = A.ea;
        System.out.println(A.ea);
        System.out.println(t.hashCode()+" "+A.eb.hashCode());
    }
}
