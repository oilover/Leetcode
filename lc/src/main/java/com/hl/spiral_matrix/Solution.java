package com.hl.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // boolean ok(int x,)
    public List<Integer> spiralOrder(int[][] matrix) {
        int dir[][] = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        final int LEFT = 0, DOWN = 1, RIGHT = 2, UP = 3;
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if (m==0) {
            return res;
        }
        int n = matrix[0].length;
        int left = 0, right = n-1, up = 0, down = m-1;
        int bound[] = new int[]{0, n-1, 0, m-1};
        int d = LEFT;
        int x=0, y=0;
        for (int i=0;i<m*n;i++) {
            res.add(matrix[x][y]);
            int xx = x, yy = y;
            x+=dir[d][0]; y+= dir[d][1];
            if (x<bound[0] || x>bound[1] || y<bound[2] || y>bound[3]) {
                 if (d==0) bound[3]++;
                 if (d==1) bound[1]--;
                 if (d==2) bound[2]--;
                bound[(d+2)%4] += (d%2==0 ? 1 : -1);
                d = (d+1)%4;
                x = xx+dir[d][0]; y = yy + dir[d][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}