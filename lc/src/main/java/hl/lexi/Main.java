package hl.lexi;

import java.util.ArrayList;
import java.util.List;

class Sol {
    private int cnt;
    int[] digit;
    int getDigit(int n) {
        digit = new int[18];
        int numDigit = 0;
        for (;n>0;n/=10) {
            digit[numDigit++] = n%10;
        }
        return numDigit;
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        cnt = 0;
        int nd = getDigit(n);
        dfs(result,nd-1, true,null, n);
        System.out.println(cnt);
        return result;
    }

    public void dfs(List<Integer> result, int i, boolean lim, Integer currentValue, int maxNum) {
        cnt++;
        if(currentValue != null && currentValue > maxNum){
            return;
        }
        if(currentValue != null) {
            result.add(currentValue);
        }
        if (i<0) {
            return;
        }
        int end = 9;
        if (lim) end=digit[i];
        for(int nextBit = 0; nextBit <= end;nextBit++){
            if(currentValue == null ){
                if(nextBit == 0) {
                    continue;
                } else {
                    currentValue = 0;
                }
            }
            dfs(result,i-1, lim&&nextBit==digit[i], currentValue*10+nextBit,maxNum);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Sol s = new Sol();
        System.out.println(s.lexicalOrder(99));
        System.out.println(s.lexicalOrder(100));
    }
}
