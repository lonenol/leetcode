package com.lone.leetcode.j;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int up = 0, down = matrix.length -1, left = 0, right = matrix[0].length - 1;
        while(true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            if( ++up > down){break;}
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if(--right < left){break;}

            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            if (--down < up) { break; }
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            if(++left > right) {break;}

        }
        return res;

    }

        public List<Integer> spiralOrder_1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i<=(m-1) / 2  ; i++) {
            int ms = i, ns = i;
            /*横着走*/
            for (int j = ns; j <= n -1 - ns; j++) {
                res.add(matrix[ms][j]);
            }
            /*竖着走*/
            for (int j = ms + 1; j <= m - 1 - ms; j++) {
                res.add(matrix[j][n - 1 -ns]);
            }
            /*反向横*/
            for (int j = n -2 - ns; j >= ns && ms != (m-ms-1); j--) {
                res.add(matrix[m - ms -1][j]);
            }
            /*反向竖*/
            for (int j = m - 2- ms; j > ms && ns != (n-1-ns); j--) {
                res.add(matrix[j][ns]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Solution54 solution54 = new Solution54();
        System.out.println(solution54.spiralOrder(matrix));
    }
}
