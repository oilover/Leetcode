package hl;

import java.util.Random;

class Node {
    int k,v;
    Node(int k,int v) {
        this.k=k; this.v= v;
    }

    @Override
    public String toString() {
        return "{" +
                "k=" + k +
                ", v=" + v +
                '}';
    }
}
public class MSort<T extends Comparable<T>> {
    protected T[] b;
//    static void merge
    static void mergeSort(Node[] a, int l, int r) {
        if (l>=r) {
            return;
        }
        int mid = (l+r)/2;
        mergeSort(a, l, mid);
        mergeSort(a, mid+1, r);
        int i=l,j=mid+1;
        int t = 0;
        Node b[] = new Node[r-l+1];
        for (int k=l;k<=r;k++) {

        }
        while (i<=mid && j<=r) {
            if (a[i].k<=a[j].k) {
                b[t] = a[i++];
            } else {
                b[t] = a[j++];
            }
            t++;
        }
        while (i<=mid) {
            b[t++] = a[i++];
        }
        while (j<=r) {
            b[t++] = a[j++];
        }
        for ( i=l;i<=r;i++) {
            a[i] = b[i-l];
        }
    }
    public static void main(String[] args) {
        Node[] a = new Node[]{new Node(1,2),new Node(1,3), new Node(0,34), new Node(3,6)};
        mergeSort(a, 0, a.length-1);

        final int N = 10;
        Random r = new Random();
        a = new Node[N];
        for (int i=0;i<N;i++) {
            a[i] = new Node(r.nextInt(6), i);
        }
        for (Node node: a) {
            System.out.print(node);
        }
        System.out.println();
        mergeSort(a, 0, a.length-1);
        for (Node node: a) {
            System.out.print(node);
        }
        System.out.println();
    }
}
