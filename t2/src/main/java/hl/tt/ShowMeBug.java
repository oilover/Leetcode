package hl.tt;

// 必须定义 `ShowMeBug` 入口类和 `public static void main(String[] args)` 入口方法
import java.util.Arrays;
public class ShowMeBug {
    static int[] add(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m<n) {
            return add(b,a);
        }
        int len = Math.max(m,n)+1;
        int[] c = new int[len];
        int carry = 0;
        for (int i=1;i<=m;i++) {
            int t = a[m-i] +  carry;
            if (i<=n) {
                t += b[n-i];
            }
            c[m-i+1] = t%10;
            carry = t/10;
        }
        c[0] = carry;
        return c;
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};//-->12345
        int[] b  = new int[]{9,3,7};//->937
        System.out.println(Arrays.toString(add(a,b)));
        a = new int[]{9,9,9};
        b = new int[]{1};
        System.out.println(Arrays.toString(add(a,b)));
        b = new int[]{9,9,9};
        a = new int[]{1};
        System.out.println(Arrays.toString(add(a,b)));
    }
}
