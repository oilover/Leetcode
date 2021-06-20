package c619.l1;

import java.util.*;

public class Solution {
    int[][] block;
    int curBlock = 0;
    int m,n;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    HashMap<Integer,Integer> area = new HashMap<>();
    boolean ok(int x,int y) {
        return (0<=x&&x<m) && (0<=y&&y<n);
    }
    void dfs(int[][] grid, int x, int y) {
        block[x][y] = curBlock;
        area.put(curBlock, area.getOrDefault(curBlock,0)+1);
        for (int i = 0; i < 4; i++) {
            int xx = x+dx[i];
            int yy = y+dy[i];
            if (ok(xx,yy) && block[xx][yy]==0 &&
                    grid[xx][yy]==grid[x][y]) {
                dfs(grid, xx, yy);
            }
        }
    }
    public int largestArea(int[][] grid) {
         m = grid.length;
         n = grid[0].length;
        area = new HashMap<>();
        block = new int[m][n];
        curBlock = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]!='0' && block[i][j]==0) {
                    curBlock++;
                    dfs(grid, i,j);
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.largestArea(new String[]{"11111100000","21243101111","21224101221","11111101111"}));
    }
}
