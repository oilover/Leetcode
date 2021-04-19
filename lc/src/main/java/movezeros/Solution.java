package movezeros;

import java.util.LinkedList;
import java.util.List;

class Solution2 {
    public String getPermutation(int n, int k) {
        int factor = 1;
        for (int i=1;i<n;i++) {
            factor*=i;
        }
        String ans = "";
        char res[] = new char[n];
        k--;
        List<Character> characters = new LinkedList<Character>();
        for (int i=1;i<=n;i++) {
            characters.add((char)(i+1+'0'));
        }
        for (int i=n-1;i>0;i--) {
            int t = k/factor;
            k%=factor;
            factor /= i;
            res[n-1-i] = characters.get(t); //(char)(t+1+'0');
            characters.remove(t);
        }
        res[n-1] = characters.get(0);
        return new String(res);
    }
}
public class Solution {
    void swap(int a[], int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
    public void moveZeros(int a[]) {
        int n = a.length;
        int l=n-1, r=n-1;
//        for (int i=)
        while (l>=0) {
            if (a[l]!=0) {
                swap(a, l, r--);
            }
            l--;
        }
        for (; l>=0; l--) {
            a[l]=0;
        }
    }

    public static void main(String[] args) {
        int a[] = {0, -1, 0, 3, 0, -1, 0, 6, 0};//{0,0,1,2,0};
        Solution2 s2 = new Solution2();
        System.out.println(s2.getPermutation(3,3));
        Solution s = new Solution();
        a = new int[]{-2,2,0};
        s.moveZeros(a);
        for (int i=0;i<a.length;i++) {
            System.out.println(a[i]);
        }
//        a= {2,9,0,2,4};
//        a = {2,0,0,0};
        System.out.println();
    }
}
