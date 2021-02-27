package heap;

import java.util.Scanner;
public class Main {

    static int recur(int f[], int n) {
        if (n<=1){
            return 1;
        }
        if (f[n]>0) {
            return f[n];
        }
        f[n] = recur(f, n-1)+recur(f, n-2);
        return f[n];
    }
    static final int mod = 1000;
    static final int matrixSize = 2;
    static int[][] mul(int [][]a, int [][]b, int n) {
        int c[][] = new int[matrixSize][matrixSize];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                for (int k=0;k<n;k++) {
                    c[i][j] = (c[i][j] + a[i][k]*b[k][j]%mod) % mod;
                }
            }
        }
        return c;
    }
    static int[][] quickPow(int a[][], int n) {
//        int res[][] = new int[matrixSize][matrixSize];
        int res[][] = {{1,0},{0,1}};
        for (; n>0; n>>=1) {
            if (n%2==1) {
                res = mul(a, res, matrixSize);
            }
            a = mul(a, a, matrixSize);
        }
        return res;
    }
    static int calc(int n) {
        int f[] = new int[n+1];
        if (n<=1) {
            return 1;
        }
        f[0]=f[1]=1;
        for (int i=2;i<=n;i++) if (i%7>0){
            f[i] = f[i-1]+f[i-2];       //  [f[i-1] f[i-2]]
            f[i-1] = f[i-1];
        }
        //  [[1 1],[1,0 ]]*[1,1]^T = [2,1]^T
        //   [1 0]
        return f[n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //  int n = in.nextInt();
        //System.out.println(a);
//        System.out.println(calc(6));
//        System.out.println(calc(7));
//        System.out.println(calc(8));
//
//        System.out.println(calc(15));
        int f[] = new int[30];
//        System.out.println(recur(f,15));
        int a[][] = {{1,1},{1,0}};
        a = quickPow(a, 7);
        System.out.println(a);
        for (int i=0;i<2;i++) {
            for (int j=0;j<2;j++) {}
        }
    }
    // log(2)+log(3)...+log(n)   nlog

    //  heap[1]<->heap[n]
}