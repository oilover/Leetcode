package c620;

import java.util.HashMap;

class Search {
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
                    grid[xx][yy]==1) {
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
                if (grid[i][j]!=0 && block[i][j]==0) {
                    curBlock++;
                    dfs(grid, i,j);
                }
            }
        }
        return 0;
    }
//    public int countSubIslands(int[][] grid1, int[][] grid2) {
//        largestArea(grid1);
//    }
}
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        Search s1 = new Search();
        Search s2 = new Search();
        s1.largestArea(grid1);
        s2.largestArea(grid2);
        int m = grid1.length, n = grid1[0].length;
        int res = 0;
        HashMap<Integer , Integer> blockMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s2.block[i][j] ==0) {
                    continue;
                }
                int b1 = s1.block[i][j];
                int b2 = s2.block[i][j];
                if (b1!=0 && !blockMap.containsKey(b2)) {
                    blockMap.put(b2,b1);
                    continue;
                }
                if (b1==0 || b1!= blockMap.get(b2)) {
                    blockMap.put(b2, -1);
                    continue;
                }
            }
        }
        for ( int v: blockMap.values()) {
            if (v!=-1) res++;
        }
        return res;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.countSubIslands(
                new int[][]{{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}},
                new int[][]{{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}}));
    }
}
