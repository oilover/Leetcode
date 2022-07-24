package hl;

import java.util.Random;

class Pair implements Comparable<Pair> {
    int k, v;

    Pair(int k, int v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public String toString() {
        return "{" + k +
//                "k=" + k +
//                ", v=" + v +
                '}';
    }

    @Override
    public int compareTo(Pair o) {
        return k - o.k;
    }
}

public class MSort<T extends Comparable<T>> {
    protected T[] b;

    void sort(T[] a) {
        int n = a.length;
        b = (T[]) new Comparable[n];
        mergeSort(a, 0, n - 1);
    }

    void mergeSort(T[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(a, l, mid);
        mergeSort(a, mid + 1, r);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                b[k] = a[j++];
                continue;
            }
            if (j > r) {
                b[k] = a[i++];
                continue;
            }
            if (a[i].compareTo(a[j]) <= 0) {
                b[k] = a[i++];
            } else {
                b[k] = a[j++];
            }
        }
        for (i = l; i <= r; i++) {
            a[i] = b[i];
        }
    }

    public static void main(String[] args) {
        final int N = 20;
        Random r = new Random();
        Pair[] a = new Pair[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Pair(r.nextInt(10), i);
        }
        for (Pair node : a) {
            System.out.print(node);
        }
        System.out.println();
        MSort<Pair> mSort = new MSort<>();
        mSort.sort(a);
        for (Pair node : a) {
            System.out.print(node);
        }
        System.out.println();
    }
}
