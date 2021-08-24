 package hl;

// [][]

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    List<Integer> solve(int[][] a, int x, int y) {
        int m = a.length;
        List<Integer> res = new ArrayList<>();
        if (m==0) {
            return res;
        }
        int n = a[0].length;
        int l=0, r=n-1 , u=0, d=m-1;
        int dir=0;
        if (n==0) {
            return res;
        }
        final int RIGHT=0;
        final int DOWN=1;
        final int LEFT=2;
        final int UP=3;
        if (x==u) {
            if (y==l) dir=RIGHT; // left
            else if (y==r) dir=DOWN; // down
        } else {
            if (y==r) dir=2; // right
            else dir=3; // up
        }
        boolean end = false;
        while (!end) {
            for (int i=0;i<4;i++,dir=(dir+1)%4) {
                if (dir==RIGHT) {
                    for (int j=l;j<=r;j++) {
                        res.add(a[u][j]);
                    }
                    u++;
                    if (u>d) {
                        end = true;
                        break;
                    }
                }
                if (dir==DOWN) {
                    for (int j = u; j <= d; j++) {
                        res.add(a[j][r]);
                    }
                    r--;
                    if (l>r) {
                        end = true;
                        break;
                    }
                }
                if (dir==LEFT) {
                    for (int j = r; j >= l; j--) {
                        res.add(a[d][j]);
                    }
                    d--;
                    if (u>d) {
                        end = true;
                        break;
                    }
                }
                if (dir==UP) {
                    for (int j = d; j >= u ; j--) {
                        res.add(a[j][l]);
                    }
                    l++;
                    if (l>r) {
                        end = true;
                        break;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String args[]) {
        // System.out.println("Hello world - Java!");
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.solve(new int[][]{{}}, 0,0));
        System.out.println(helloWorld.solve(new int[][]{{3}}, 0,0));
        System.out.println(helloWorld.solve(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}, 0,0));
        System.out.println(helloWorld.solve(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}, 0,3));
        System.out.println(helloWorld.solve(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}, 2,0));
        System.out.println(helloWorld.solve(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}, 2,3));
    }
}

