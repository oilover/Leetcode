package com.hl.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int dir[][] = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
//        final int LEFT = 0, DOWN = 1, RIGHT = 2, UP = 3;
        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if (m==0) {
            return res;
        }
        int n = matrix[0].length;
        int left = 0, right = n-1, up = 0, down = m-1;
//        int bound[] = new int[]{0, n-1, 0, m-1};
//        int d = LEFT;
//        int x=0, y=0;
        while (true) {
            for (int i=left;i<=right;i++) {
                res.add(matrix[up][i]);
            }
            if (++up>down) break;
            for (int i=up;i<=down;i++) {
                res.add(matrix[i][right]);
            }
            if (--right<left) break;
            for (int i=right;i>=left;i--) {
                res.add(matrix[down][i]);
            }
            if (--down<up) break;
            for (int i=down;i>=up;i--) {
                res.add(matrix[i][left]);
            }
            if (++left>right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3},{3,4,8}}));
        System.out.println(solution.spiralOrder(new int[][]{{1,2},{3,4}}));
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}