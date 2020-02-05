package com.lone.leetcode.j;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximal-rectangle/
 * 思路: 首先想到的是动态规划..
 * 1. 用82 题的最大矩形求解,每一行都可以抽象成一个坐标抽
 * 2. dp 官网给的是压缩路径之后的做法,又没有说明,因此非常难以理解.还原成普通的 dp 之后就容易理解很多
 *    left 和 right 代表的是当前这个点最高的那个点向左右能展开的宽度,但是计算的时候并没有比较高度,所以直接看压缩的算法的时候就有点蒙蔽
 *    left 和 right 的计算原理是一样的,以 left[i][j] 举例(下面的描述需要脑坐标轴):
 *    curLeft 是当前点向左延伸的宽度,即左边的 '1' 能到哪一个点,    left[i-1][j]是 当前这个点上边的那个点最大高度能像左延伸到的点:
 *    此时如果 curLeft 在 left[i-1][j]的左边,那就等于在上一行的底下铺了更多的 1,当前点的最大高度就和left[i][j-1]相同,因为更左边当前行虽然是 1,但是上面的行不满足,构成不了矩形.
 *    如果 curLeft 在 left[i-1][j]右侧,那向左最大宽度就是 curLeft(矩形边窄了)
 *    这个的正确性在于第一行(i=0时)高度肯定为 1,不需要考虑更上一行,所以 i=0 时能得到正确值,i>0 && i<n的每一行都依赖上一行,所以能通过第一行的值计算出正确的值.
 */
public class Solution85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(right[i], n);
        }
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n;
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    if(i == 0) {
                        height[i][j] = 1;
                        left[i][j] = curLeft;
                    } else {
                        height[i][j] = height[i-1][j] + 1;
                        left[i][j] = Math.max(left[i-1][j],curLeft);
                    }
                } else {
                    curLeft = j+1;
                }
            }
            for(int j = n-1; j>=0; j--) {
                if(matrix[i][j] == '1') {
                    if(i == 0) {
                        right[i][j] = curRight;
                    } else {
                        right[i][j] = Math.min(right[i-1][j],curRight);
                    }
                } else {
                    curRight = j;
                }
            }
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, (right[i][j] - left[i][j]) * height[i][j]);
            }
        }
        return maxArea;

    }

    public int maximalRectangle_dp(char[][] matrix) {
        if (matrix.length == 0) { return 0; }
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n]; // initialize left as the leftmost boundary possible
        int[] right = new int[n];
        int[] height = new int[n];

        Arrays.fill(right, n); // initialize right as the rightmost boundary possible

        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // update height
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') { height[j]++; } else { height[j] = 0; }
            }
            // update left
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') { left[j] = Math.max(left[j], cur_left); } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') { right[j] = Math.min(right[j], cur_right); } else {
                    right[j] = n;
                    cur_right = j;
                }
            }
            // update area
            for (int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        Solution85 solution85 = new Solution85();
        char[][] matrix = new char[1][2];
        matrix[0] = new char[] {'0', '1'};
        solution85.maximalRectangle(matrix);
    }
}
