package tmp;
//        求一个数组中顺序对的个数（复杂度要求O（nlogn）），并打印所有的顺序对；
//        如数组{​​​1，3，6，5}​​​，顺序对总共有5对，{​​​1，3}​​​，{​​​1，6}​​​，{​​​1，5}​​​，{​​​3，6}​​​，{​​​3，5}​​​；

public class Main {
    int[] b;
    long count(int[] a, int l, int r) {
        if (l>=r) {
            return 0;
        }
        int mid=(l+r)/2;
        long ans = count(a, l, mid) + count(a, mid+1, r);
        int i=l, j=mid+1;
        for (int k=l;k<=r;k++) {
            if (i>mid) {
                b[k] = a[j++];
                continue;
            }
            if (j>r) {
                b[k] = a[i++];
                continue;
            }
            if (a[i]>=a[j]) {
                b[k] = a[i++];
            } else { // a[i]<a[j]  a[i-1]>=a[j] , a[i]..a[mid] 都小于 a[j]
                ans += mid-i+1;
                b[k] = a[j++];
            }
        }
        for (int k = l; k < r; k++) {
            a[k] = b[k];
        }
        return ans;
    }
    long countPairs(int[] a) {
        b = new int[a.length];
        return count(a, 0, a.length-1);
    }
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.countPairs(new int[]{1,2,6,5}));
        System.out.println(m.countPairs(new int[]{6,3,1}));
        System.out.println(m.countPairs(new int[]{1,7,8}));
        System.out.println(m.countPairs(new int[]{7,7,7}));
        System.out.println(m.countPairs(new int[]{1,7,8,6,3,1}));
    }
}
