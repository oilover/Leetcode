package amazon.orange;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        if (n==0) {
            return 0;
        }
        int m = grid[0].length;
        int cnt = 0;
        for (int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==2) {
                    queue.offer(new int[]{i,j,0});
                }
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            ans = p[2];
            for (int i=0;i<4;i++) {
                int x = p[0]+dx[i];
                int y = p[1]+dy[i];
                if ((0<=x&&x<n) && (0<=y&&y<m) && grid[x][y]==1) {
                    grid[x][y] = 2;
                    cnt --;
                    queue.offer(new int[]{x,y,p[2]+1});
                }
            }
        }
        if (cnt>0) {
            return -1;
        }
        return ans;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }
}
