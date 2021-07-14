import java.util.Random;

public class QSort {

    static void partition(int[] a, int l, int r) {
        if (l>=r) {
            return;
        }
        int pivot = a[r];
        int j=l-1;
        for (int i = l; i <= r; i++) {
            if (a[i]<=pivot){
                int t = a[++j];
                a[j] = a[i];
                a[i] = t;
            }
        }
        partition(a, l, j-1);
        partition(a, j+1, r);
    }

    public static void main(String[] args) {
        final int N = 20;
        int[] a = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = (int)(random.nextInt(100));
        }
        for (int x:a) {
            System.out.printf("%4d",x);
        }
        partition(a, 0, N-1);
        System.out.println();
        for (int x:a) {
            System.out.printf("%4d",x);
        }
    }
}
